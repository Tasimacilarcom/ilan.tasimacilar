package com.tasimacilar.ilan.common;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
@ManagedBean(name = "socialMediaBean")
@ViewScoped
public class SocialMediaBean implements Serializable{
    private String  SocialMedia_Id;                  
    private String  facebook_profileUrl;
    private String  twitter_profileUrl;
    private String  linkedin_profileUrl;
    private String  whatsApp_profileUrl;
    private String  weChat_profileUrl;
    private String  tumblr_profileUrl;
    private String  instagram_profileUrl;
    private String  google_profileUrl;
    private String  skype_profileUrl;
    private String  viber_profileUrl;
    private String  line_profileUrl;
    private String  snapchat_profileUrl;
    private String  pinterest_profileUrl;
    private String  telegram_profileUrl;
    private String  reddit_profileUrl;
    private String  foursquare_profileUrl;
    private String  myspace_profileUrl;
    private String  youTube_profileUrl;
    private String  vine_profileUrl;
    private String  xing_profileUrl;
    private String  flickr_profileUrl;
    private String  meetup_profileUrl;
    private Date    create_time;
    private String  last_change_time;
    private String  last_Changer_account_id;
    @PostConstruct
    public void init() {  }
     public SocialMediaBean() { }
    public SocialMediaBean( String SocialMedia_Id, int SocialMedia_RelationId, 
                            String facebook_profileUrl, String twitter_profileUrl, 
                            String linkedin_profileUrl, String whatsApp_profileUrl, 
                            String weChat_profileUrl, String tumblr_profileUrl, 
                            String instagram_profileUrl, String google_profileUrl, 
                            String skype_profileUrl, String viber_profileUrl, 
                            String line_profileUrl, String snapchat_profileUrl, 
                            String pinterest_profileUrl, String telegram_profileUrl, 
                            String reddit_profileUrl, String foursquare_profileUrl, 
                            String myspace_profileUrl, String youTube_profileUrl, 
                            String vine_profileUrl, String xing_profileUrl, 
                            String flickr_profileUrl, String meetup_profileUrl) {
        this.SocialMedia_Id = SocialMedia_Id;
        this.facebook_profileUrl = facebook_profileUrl;
        this.twitter_profileUrl = twitter_profileUrl;
        this.linkedin_profileUrl = linkedin_profileUrl;
        this.whatsApp_profileUrl = whatsApp_profileUrl;
        this.weChat_profileUrl = weChat_profileUrl;
        this.tumblr_profileUrl = tumblr_profileUrl;
        this.instagram_profileUrl = instagram_profileUrl;
        this.google_profileUrl = google_profileUrl;
        this.skype_profileUrl = skype_profileUrl;
        this.viber_profileUrl = viber_profileUrl;
        this.line_profileUrl = line_profileUrl;
        this.snapchat_profileUrl = snapchat_profileUrl;
        this.pinterest_profileUrl = pinterest_profileUrl;
        this.telegram_profileUrl = telegram_profileUrl;
        this.reddit_profileUrl = reddit_profileUrl;
        this.foursquare_profileUrl = foursquare_profileUrl;
        this.myspace_profileUrl = myspace_profileUrl;
        this.youTube_profileUrl = youTube_profileUrl;
        this.vine_profileUrl = vine_profileUrl;
        this.xing_profileUrl = xing_profileUrl;
        this.flickr_profileUrl = flickr_profileUrl;
        this.meetup_profileUrl = meetup_profileUrl;
    }
    public String getSocialMedia_Id() {return SocialMedia_Id;}
    public void setSocialMedia_Id(String SocialMedia_Id) {this.SocialMedia_Id = SocialMedia_Id;}
    public String getFacebook_profileUrl() {return facebook_profileUrl;}
    public void setFacebook_profileUrl(String facebook_profileUrl) {this.facebook_profileUrl = facebook_profileUrl;}
    public String getTwitter_profileUrl() {return twitter_profileUrl;}
    public void setTwitter_profileUrl(String twitter_profileUrl) {this.twitter_profileUrl = twitter_profileUrl;}
    public String getLinkedin_profileUrl() {return linkedin_profileUrl;}
    public void setLinkedin_profileUrl(String linkedin_profileUrl) {this.linkedin_profileUrl = linkedin_profileUrl;}
    public String getWhatsApp_profileUrl() {return whatsApp_profileUrl;}
    public void setWhatsApp_profileUrl(String whatsApp_profileUrl) {this.whatsApp_profileUrl = whatsApp_profileUrl;}
    public String getWeChat_profileUrl() {return weChat_profileUrl;}
    public void setWeChat_profileUrl(String weChat_profileUrl) {this.weChat_profileUrl = weChat_profileUrl;}
    public String getTumblr_profileUrl() {return tumblr_profileUrl;}
    public void setTumblr_profileUrl(String tumblr_profileUrl) {this.tumblr_profileUrl = tumblr_profileUrl;}
    public String getInstagram_profileUrl() {return instagram_profileUrl;}
    public void setInstagram_profileUrl(String instagram_profileUrl) {this.instagram_profileUrl = instagram_profileUrl;}
    public String getGoogle_profileUrl() {return google_profileUrl;}
    public void setGoogle_profileUrl(String google_profileUrl) {this.google_profileUrl = google_profileUrl;}
    public String getSkype_profileUrl() { return skype_profileUrl;}
    public void setSkype_profileUrl(String skype_profileUrl) {this.skype_profileUrl = skype_profileUrl;}
    public String getViber_profileUrl() {return viber_profileUrl;}
    public void setViber_profileUrl(String viber_profileUrl) {this.viber_profileUrl = viber_profileUrl;}
    public String getLine_profileUrl() {return line_profileUrl;}
    public void setLine_profileUrl(String line_profileUrl) {this.line_profileUrl = line_profileUrl;}
    public String getSnapchat_profileUrl() {return snapchat_profileUrl;}
    public void setSnapchat_profileUrl(String snapchat_profileUrl) {this.snapchat_profileUrl = snapchat_profileUrl;}
    public String getPinterest_profileUrl() {return pinterest_profileUrl;}
    public void setPinterest_profileUrl(String pinterest_profileUrl) {this.pinterest_profileUrl = pinterest_profileUrl;}
    public String getTelegram_profileUrl() {return telegram_profileUrl;}
    public void setTelegram_profileUrl(String telegram_profileUrl) {this.telegram_profileUrl = telegram_profileUrl;}
    public String getReddit_profileUrl() {return reddit_profileUrl;}
    public void setReddit_profileUrl(String reddit_profileUrl) {this.reddit_profileUrl = reddit_profileUrl;}
    public String getFoursquare_profileUrl() {return foursquare_profileUrl;}
    public void setFoursquare_profileUrl(String foursquare_profileUrl) {this.foursquare_profileUrl = foursquare_profileUrl;}
    public String getMyspace_profileUrl() { return myspace_profileUrl;}
    public void setMyspace_profileUrl(String myspace_profileUrl) {this.myspace_profileUrl = myspace_profileUrl;}
    public String getYouTube_profileUrl() {return youTube_profileUrl;}
    public void setYouTube_profileUrl(String youTube_profileUrl) {this.youTube_profileUrl = youTube_profileUrl;}
    public String getVine_profileUrl() {return vine_profileUrl;}
    public void setVine_profileUrl(String vine_profileUrl) {this.vine_profileUrl = vine_profileUrl;}
    public String getXing_profileUrl() {return xing_profileUrl;}
    public void setXing_profileUrl(String xing_profileUrl) {this.xing_profileUrl = xing_profileUrl;}
    public String getFlickr_profileUrl() {return flickr_profileUrl;}
    public void setFlickr_profileUrl(String flickr_profileUrl) {this.flickr_profileUrl = flickr_profileUrl;}
    public String getMeetup_profileUrl() {return meetup_profileUrl;}
    public void setMeetup_profileUrl(String meetup_profileUrl) {this.meetup_profileUrl = meetup_profileUrl;}
    public Date getCreate_time() {return create_time;}
    public void setCreate_time(Date create_time) { this.create_time = create_time;}
    public String getLast_change_time() {return last_change_time;}
    public void setLast_change_time(String last_change_time) {this.last_change_time = last_change_time;}
    public String getLast_Changer_account_id() {return last_Changer_account_id;}
    public void setLast_Changer_account_id(String last_Changer_account_id) { this.last_Changer_account_id = last_Changer_account_id;}

    
}
