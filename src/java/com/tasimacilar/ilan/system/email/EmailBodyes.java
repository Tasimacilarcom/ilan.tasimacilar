/**
 * @author  Yasin KALAYCI (ykalayci@hotmail.com)
 * @since   01-01-2019 
 * @version 1.0.0
 */
package com.tasimacilar.ilan.system.email;


public class EmailBodyes {


    public static String userRegisterEmailBody(String userName, String userSurname, String userActivicationId){
    
        return  "<!doctype html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta charset=\"utf-8\">\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "<title>tsimacilar.com</title>\n" +
                "\n" +
                "\n" +
                "<style type=\"text/css\">\n" +
                "	\n" +
                "body {margin: 0;}\n" +
                "body, table, td, p, a, li, blockquote {-webkit-text-size-adjust: none!important;font-family: sans-serif;font-style: normal;font-weight: 400;}\n" +
                "\n" +
                "@media screen and (max-width:600px) {\n" +
                "	body, table, td, p, a, li, blockquote {-webkit-text-size-adjust: none!important;font-family: sans-serif;}\n" +
                "	table {width: 100%;}\n" +
                "}\n" +
                "\n" +
                "@media screen and (max-width:480px) {\n" +
                "	body, table, td, p, a, li, blockquote {-webkit-text-size-adjust: none!important;font-family: sans-serif;}\n" +
                "	table {width: 100% !important;border-style: none !important;}\n" +
                "}\n" +
                "	\n" +
                "</style>\n" +
                "\n" +
                "</head>\n" +
                "<body style=\"padding: 15px;\">\n" +
                "\n" +
                "<table width=\"100%\"  cellspacing=\"0\" cellpadding=\"0\" >\n" +
                " \n" +
                "  <tbody>\n" +
                "   \n" +
                "    <tr>\n" +
                "     \n" +
                "   	  <td>\n" +
                "        	<table width=\"800\"  align=\"left\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "         \n" +
                "          <tbody>\n" +
                "\n" +
                "			<tr>\n" +
                "				<td bgcolor=\"#d0cfcf\"  width=\"100%\"  align=\"left\" cellpadding=\"0\" cellspacing=\"0\" style=\"padding:10px 10px 10px 20px; color: #929292\">\n" +
                "					tasimacilar.com \n" +
                "				</td>\n" +
                "			</tr>\n" +
                "\n" +
                "			<tr> \n" +
                "			  <td width=\"100%\"  align=\"left\" cellpadding=\"0\" cellspacing=\"0\" \n" +
                "					style=\"font-size: 14px; color: #929292; border: 1px solid #d0cfcf; line-height: 1.2; padding:20px 20px 20px 20px; font-family: sans-serif;\">\n" +
                "				<h4 style=\"padding: 0px; padding-top: 10px; margin: 0px;\">Merhaba "+userName+"&nbsp;"+userSurname+";</h4>\n" +
                "				   <p>ilan.tasimacilar.com web sitemiz üzerinden üyelik talebinizi aldık,<br>\n" +
                "			    üyelik işlemlerinin tamamlanması ve hesamınızın etkinleştirilmesi için aşağıdaki etkinleştirme kodunu <a href=\"http://ilan.tasimacilar.com/activation\">buraya</a> girerek hesabınızı etkinleştiriniz.</p>\n" +
                "					 <p>Etkinleştirme kodunuz : <span style=\"color: #B30306; font-size: 20px; background-color: #FCECEC; \">"+userActivicationId+"</span><br>\n" +
                "					 <br>\n" +
                "					 Eğer bu işlemin bir hata olduğunu veya sizin isteğinizin dışınızda gerçekleştiğini düşünüyorsanız\n" +
                "					 lütfen bizimle <a href=\"http://ilan.tasimacilar.com/iletisim\">iletişime</a> geçiniz.<br><br>\n" +
                "					 Saygılarımızla;<br/>\n" +
                "				  <br>\n" +
                "			    </p>\n" +
                "				</td>\n" +
                "			</tr>\n" +
                "\n" +
                "			<tr bgcolor=\"#d0cfcf\">\n" +
                "				<td  width=\"48%\"  align=\"left\" cellpadding=\"0\" cellspacing=\"0\" style=\"padding:10px 10px 10px 20px;\">\n" +
                "				<p style=\"font-size: 11px; color:#929292;  font-family: sans-serif;\">Bu ileti, takip edilmeyen bir e-posta adresinden gönderildi. Lütfen bu iletiyi yanıtlamayın.</p>\n" +
                "				<p style=\"font-size: 11px; color:#929292;  font-family: sans-serif;\">Telif Hakkı © 2019 tasimacilar.com . Tüm hakları saklıdır.</p>\n" +
                "			 </td>\n" +
                "			</tr>\n" +
                "            \n" +
                "          </tbody>\n" +
                "          \n" +
                "        </table>\n" +
                "		</td>\n" +
                "        \n" +
                "    </tr>\n" +
                "    \n" +
                "  </tbody>\n" +
                "  \n" +
                "</table>\n" +
                "</body>\n" +
                "</html>";

    }
    public static String UserMessageNotificationEmailBody(String userName){
    
        return  "<!doctype html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta charset=\"utf-8\">\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "<title>tsimacilar.com</title>\n" +
                "\n" +
                "\n" +
                "<style type=\"text/css\">\n" +
                "	\n" +
                "body {margin: 0;}\n" +
                "body, table, td, p, a, li, blockquote {-webkit-text-size-adjust: none!important;font-family: sans-serif;font-style: normal;font-weight: 400;}\n" +
                "\n" +
                "@media screen and (max-width:600px) {\n" +
                "	body, table, td, p, a, li, blockquote {-webkit-text-size-adjust: none!important;font-family: sans-serif;}\n" +
                "	table {width: 100%;}\n" +
                "}\n" +
                "\n" +
                "@media screen and (max-width:480px) {\n" +
                "	body, table, td, p, a, li, blockquote {-webkit-text-size-adjust: none!important;font-family: sans-serif;}\n" +
                "	table {width: 100% !important;border-style: none !important;}\n" +
                "}\n" +
                "	\n" +
                "</style>\n" +
                "\n" +
                "</head>\n" +
                "<body style=\"padding: 15px;\">\n" +
                "\n" +
                "<table width=\"100%\"  cellspacing=\"0\" cellpadding=\"0\" >\n" +
                " \n" +
                "  <tbody>\n" +
                "   \n" +
                "    <tr>\n" +
                "     \n" +
                "   	  <td>\n" +
                "        	<table width=\"800\"  align=\"left\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "         \n" +
                "          <tbody>\n" +
                "\n" +
                "			<tr>\n" +
                "				<td bgcolor=\"#d0cfcf\"  width=\"100%\"  align=\"left\" cellpadding=\"0\" cellspacing=\"0\" style=\"padding:10px 10px 10px 20px; color: #929292\">\n" +
                "					tasimacilar.com \n" +
                "				</td>\n" +
                "			</tr>\n" +
                "\n" +
                "			<tr> \n" +
                "			  <td width=\"100%\"  align=\"left\" cellpadding=\"0\" cellspacing=\"0\" \n" +
                "					style=\"font-size: 14px; color: #929292; border: 1px solid #d0cfcf; line-height: 1.2; padding:20px 20px 20px 20px; font-family: sans-serif;\">\n" +
                "				<h4 style=\"padding: 0px; padding-top: 10px; margin: 0px;\">Merhaba "+userName+"&nbsp;</h4>\n" +
                "				   <p>ilan.tasimacilar.com web sitemiz üzerindeki ilanınız için yeni bir mesaj aldınız.<br>\n" +
                "			    Mesajınızı okumak için lütfen sitemize giriş yapınız profil sayfasındaki ilan mesajlarım bölümünü ziyaret ediniz.</p>\n" +
                "					 <p><br>\n" +
                "					 Eğer bu işlemin bir hata olduğunu veya sizin isteğinizin dışınızda gerçekleştiğini düşünüyorsanız\n" +
                "					 lütfen bizimle <a href=\"http://ilan.tasimacilar.com/iletisim\">iletişime</a> geçiniz.<br><br>\n" +
                "					 Saygılarımızla;<br/>\n" +
                "				  <br>\n" +
                "			    </p>\n" +
                "				</td>\n" +
                "			</tr>\n" +
                "\n" +
                "			<tr bgcolor=\"#d0cfcf\">\n" +
                "				<td  width=\"48%\"  align=\"left\" cellpadding=\"0\" cellspacing=\"0\" style=\"padding:10px 10px 10px 20px;\">\n" +
                "				<p style=\"font-size: 11px; color:#929292;  font-family: sans-serif;\">Bu ileti, takip edilmeyen bir e-posta adresinden gönderildi. Lütfen bu iletiyi yanıtlamayın.</p>\n" +
                "				<p style=\"font-size: 11px; color:#929292;  font-family: sans-serif;\">Telif Hakkı © 2019 tasimacilar.com . Tüm hakları saklıdır.</p>\n" +
                "			 </td>\n" +
                "			</tr>\n" +
                "            \n" +
                "          </tbody>\n" +
                "          \n" +
                "        </table>\n" +
                "		</td>\n" +
                "        \n" +
                "    </tr>\n" +
                "    \n" +
                "  </tbody>\n" +
                "  \n" +
                "</table>\n" +
                "</body>\n" +
                "</html>";

    }


    
    
    
}
