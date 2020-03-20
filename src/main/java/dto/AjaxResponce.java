package dto;

import java.io.Serializable;

/**
 * Created by Administrator on 5/2/2017.
 */
public class AjaxResponce implements Serializable{
private String code;
private String message;
private Object data;

public String getCode(){
  return code;
}

public void setCode(String code){
  this.code=code;
}

public String getMessage(){
  return message;
}

public void setMessage(String message){
  this.message=message;
}

public Object getData(){
  return data;
}

public void setData(Object data){
  this.data=data;
}
}
