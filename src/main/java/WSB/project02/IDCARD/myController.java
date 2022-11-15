/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WSB.project02.IDCARD;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Rifqi Ichsan A
 */
@Controller
public class myController {
    
    @RequestMapping("/sendData")
    @ResponseBody
    public String getData(@RequestParam("mytext") String getText,
                          @RequestParam("myimage") MultipartFile image,
                          @RequestParam("mydate") @DateTimeFormat(pattern="yyyy-MM-dd") Date myDate) 
        
        throws IOException{
        
        SimpleDateFormat tanggal = new SimpleDateFormat("dd-MMMM-yyyy");
        String NewTanggal = tanggal.format(myDate);
        String blob = Base64.encodeBase64String(image.getBytes());
        
        return  "<fieldset align='justify'>"+
                "<b>"+"Kartu Tanda Pengenal"+"</b>"+"<hr>"+"<br><br>"+"Nama : "+
                getText+"<br><br>"+"Tanggal Lahir : "+NewTanggal+
                "<p align='center'><img src='data:image/jpeg;base64," +blob+ " ' />"+"</fieldset>";
    }
}
