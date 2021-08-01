//package com.cci.controller;
//
//import com.cci.model.Usuario;
//import com.cci.service.ServicioCorreo;
//import com.cci.service.UsuarioDao;
//import java.io.Serializable;
//import java.util.List;
//import java.util.Properties;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
//import java.util.Properties;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.AddressException;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
//@ManagedBean(name = "emailController")
//@SessionScoped
//public class EmailController implements Serializable {
//
//    
//    private String Username;
//private String Password;
//private String code,vericode;
//private Usuario usuario= new Usuario();
//private List<Usuario> listaUsuario;
//
//    public EmailController(String Username, String Password, String code, String vericode, List<Usuario> listaUsuario) {
//        this.Username = Username;
//        this.Password = Password;
//        this.code = code;
//        this.vericode = vericode;
//        this.listaUsuario = listaUsuario;
//    }
//
//    public List<Usuario> getListaUsuario() {
//        return listaUsuario;
//    }
//
//    public void setListaUsuario(List<Usuario> listaUsuario) {
//        this.listaUsuario = listaUsuario;
//    }
//
//
//public String verificacionCorreo(){
//String str;
//
//        String para;
//        
//    ServicioCorreo servicioCorreo= new ServicioCorreo();
//    boolean resultado;
//    boolean aprobado;
//    
//    Usuario validarCorreo=servicioCorreo.CorreoUsuario(Username);
//    this.listaUsuario=servicioCorreo.buscarTodos();
//    if(validarCorreo==null){
//        aprobado= false;
//        para="";
//        return "NO";
//        
//    }   else{
//        aprobado=true;
//       para= Username;
//       aprobado = enviarCorreo(para);
//        
//        
//    } 
//    
// return "Si";
//
//
//}
//
//public boolean enviarCorreo(String para){
//  String username="whateverbum04@gmail.com";
//  String Password="corales1";
//  String from= username;
//  String vericode,code;
//  boolean aprobado;
//  ServicioCorreo servicioCorreo =  new ServicioCorreo();
//  Usuario use = new Usuario();
//  
//  
//  boolean res=false;
//  Properties props = new Properties();
//  props.put("mai.smtp.Starttls.enable","true");
//    props.put("mail.smtp.port", "587");
//            props.put("mail.smtp.auth", "true");
//            props.put("mail.smtp.starttls.required", "true");
//            props.put("mail.debug","true");
//        
//
//        Session session = Session.getInstance(props, new javax.mail.Authenticator(){
//        protected PasswordAuthentication getPasswordAuthentication(){
//                    return new PasswordAuthentication(username,Password);
//                }
//        });
//     try{
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(from));
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(para));
//            message.setSubject("Recuperación de contraseña Preguntic");
//            message.setText("Su código temporal para recuperar la contraseña es: " + token);
//            Transport.send(message);
//            actualizarTokenBD(to,token);
//            
//          
//        
//        }catch(MessagingException e){
//        
//            throw new RuntimeException(e);
//        }
//            res=true;
//       return res;
//}
//        
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    public String getUsername() {
//        return Username;
//    }
//
//    public void setUsername(String Username) {
//        this.Username = Username;
//    }
//
//    public String getPassword() {
//        return Password;
//    }
//
//    public void setPassword(String Password) {
//        this.Password = Password;
//    }
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public String getVericode() {
//        return vericode;
//    }
//
//    public void setVericode(String vericode) {
//        this.vericode = vericode;
//    }
//
//    public Usuario getUsuario() {
//        return usuario;
//    }
//
//    public void setUsuario(Usuario usuario) {
//        this.usuario = usuario;
//    }
//
//           
//}
