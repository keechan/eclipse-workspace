package board.comment;

import lombok.Data;

@Data
public class BoardVO {
  private   String  idx;
  private   String  sname;
  private   String  title;
  private   String  content;
  private   int  cnt;
  private String postCode;
  private String address;
  private String detailAddress;
  private String extraAddress;  
}
