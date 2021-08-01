package com.cci.controller;

import com.cci.model.Biblioteca;
import com.cci.service.ServicioBiblioteca;
import com.cci.service.ServicioFTP;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.apache.commons.io.FilenameUtils;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;


/**
 *
 * @author Anny Mora
 */

@ManagedBean(name = "bibliotecaController")
@SessionScoped
public class BibliotecaController extends ServicioFTP implements Serializable{
    private String datoBuscar;
    private UploadedFile file;
    private StreamedContent fileDownload;
    private List<Biblioteca> listaBiblioteca;
    public String ruta;

    public BibliotecaController() {
         traerArchivos();
    }

    public BibliotecaController(String datoBuscar, UploadedFile file, StreamedContent fileDownload, List<Biblioteca> listaBiblioteca, String ruta) {
        this.datoBuscar = datoBuscar;
        this.file = file;
        this.fileDownload = fileDownload;
        this.listaBiblioteca = listaBiblioteca;
        this.ruta = ruta;
    }

    public String getDatoBuscar() {
        return datoBuscar;
    }

    public void setDatoBuscar(String datoBuscar) {
        this.datoBuscar = datoBuscar;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public StreamedContent getFileDownload() {
        return fileDownload;
    }

    public void setFileDownload(StreamedContent fileDownload) {
        this.fileDownload = fileDownload;
    }

    public List<Biblioteca> getListaBiblioteca() {
        return listaBiblioteca;
    }

    public void setListaBiblioteca(List<Biblioteca> listaBiblioteca) {
        this.listaBiblioteca = listaBiblioteca;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
    public void subirArchivo() throws IOException {
        
        Biblioteca bi = new Biblioteca();
        ServicioFTP ftp = new ServicioFTP();
        super.abrirConexion();
        ServicioBiblioteca sb =  new ServicioBiblioteca(); 
       
        String filename = FilenameUtils.getBaseName(file.getFileName());
        bi.setNombre(filename);
        String extension = FilenameUtils.getExtension(file.getFileName());
        bi.setExtension(extension);
        bi.setPathArchivo('/' + bi.getNombre() + '.' + bi.getExtension());
        System.out.println("Start uploading first file");

        boolean done = ftpClient.storeFile(filename + "." + extension, file.getInputstream());
        if (done) {
            System.out.println("The first file is uploaded successfully.");
        }
        sb.agregarArchivo(bi);

        super.cerrarConexion();
       //llamar metodo de insertar a la base de datos

    }
        
     public void bajarArchivo() throws IOException {
        super.abrirConexion();
        String remoteFile = "/" + ruta;
        InputStream inputStream = ftpClient.retrieveFileStream(remoteFile);
        this.fileDownload = new DefaultStreamedContent(inputStream, "application/", ruta);
        super.cerrarConexion();
    }
    
     public void traerArchivos(){
         ServicioBiblioteca sBiblioteca = new ServicioBiblioteca();
         listaBiblioteca = sBiblioteca.obtenerListaDocumentos();     
     
     }
     
     public void onSelect(SelectEvent event) {
            Biblioteca object = (Biblioteca) event.getObject();
            ruta = object.getNombre();



        }

        
}