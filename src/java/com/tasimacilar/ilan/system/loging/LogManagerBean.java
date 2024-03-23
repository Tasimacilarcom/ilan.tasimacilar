package com.tasimacilar.ilan.system.loging;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
@ManagedBean(name = "logManagerBean")
@ViewScoped
public class LogManagerBean implements Serializable{
    
    private String  logId;
    private String  logLevel="";
    private String  logsource="";
    private String  logContent="";
    private String  logUser="";
    private boolean logShowing;
    private Date    logCreateTime;
    private Date    logChangeTime;
     public LogManagerBean() {  }
 public LogManagerBean( String logId, 
                           String logLevel, 
                           String logsource, 
                           String logComment, 
                           String logUser, 
                           boolean logShowing, 
                           Date logCreateTime, 
                           Date logChangeTime) {
        this.logId = logId;
        this.logLevel = logLevel;
        this.logsource = logsource;
        this.logContent = logComment;
        this.logUser = logUser;
        this.logShowing = logShowing;
        this.logCreateTime = logCreateTime;
        this.logChangeTime = logChangeTime;
    } public String getLogId() {return logId;}
    public void setLogId(String logId) {this.logId = logId;}
    public String getLogLevel() {return logLevel;}
    public void setLogLevel(String logLevel) {this.logLevel = logLevel;}
    public String getLogsource() {return logsource;}
    public void setLogsource(String logsource) {this.logsource = logsource;}
    public String getLogContent() {return logContent;}
    public void setLogContent(String logContent) {this.logContent = logContent;}
    public String getLogUser() {return logUser;}
    public void setLogUser(String logUser) {this.logUser = logUser;}
    public boolean isLogShowing() {return logShowing;}
    public void setLogShowing(boolean logShowing) {this.logShowing = logShowing;}
    public Date getLogCreateTime() {return logCreateTime;}
    public void setLogCreateTime(Date logCreateTime) {this.logCreateTime = logCreateTime;}
    public Date getLogChangeTime() {return logChangeTime;}
    public void setLogChangeTime(Date logChangeTime) {this.logChangeTime = logChangeTime;}
     @Override
    public String toString() {
        return "LogManagerBean{" + "logId=" + logId 
                                 + ", logLevel=" + logLevel 
                                 + ", logsource=" + logsource 
                                 + ", logComment=" + logContent 
                                 + ", logUser=" + logUser 
                                 + ", logShowing=" + logShowing 
                                 + ", logCreateTime=" + logCreateTime 
                                 + ", logChangeTime=" + logChangeTime + '}';
    }
     public List<LogManagerBean> listAllLog(){
        
        LogManagerDao lmd = new LogManagerDao();
        
        return lmd.listAllLog();
    }

    
    

    
    
    
    
    
    
}
