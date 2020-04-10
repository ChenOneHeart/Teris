/*    */ package config;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ButtonConfig
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = -1643673420834870317L;
/*    */   private final int buttonW;
/*    */   private final int buttonH;
/*    */   private final int startX;
/*    */   private final int startY;
/*    */   private final int userConfigX;
/*    */   private final int userConfigY;
/*    */   
/*    */   public ButtonConfig(Element button) {
/* 27 */     this.buttonW = Integer.parseInt(button.attributeValue("w"));
/* 28 */     this.buttonH = Integer.parseInt(button.attributeValue("h"));
/* 29 */     this.startX = Integer.parseInt(button.element("start").attributeValue("x"));
/* 30 */     this.startY = Integer.parseInt(button.element("start").attributeValue("y"));
/* 31 */     this.userConfigX = Integer.parseInt(button.element("userConfig").attributeValue("x"));
/* 32 */     this.userConfigY = Integer.parseInt(button.element("userConfig").attributeValue("y"));
/*    */   }
/*    */ 
/*    */   
/* 36 */   public int getButtonW() { return this.buttonW; }
/*    */ 
/*    */ 
/*    */   
/* 40 */   public int getButtonH() { return this.buttonH; }
/*    */ 
/*    */ 
/*    */   
/* 44 */   public int getStartX() { return this.startX; }
/*    */ 
/*    */ 
/*    */   
/* 48 */   public int getStartY() { return this.startY; }
/*    */ 
/*    */ 
/*    */   
/* 52 */   public int getUserConfigX() { return this.userConfigX; }
/*    */ 
/*    */ 
/*    */   
/* 56 */   public int getUserConfigY() { return this.userConfigY; }
/*    */ }


/* Location:              D:\Code\俄罗斯方块1.0\Tetris.jar!\config\ButtonConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */