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
/*    */ public class DataConfig
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = -7583588435372492962L;
/*    */   private final int maxRow;
/*    */   private final DataInterfaceConfig dataA;
/*    */   private final DataInterfaceConfig dataB;
/*    */   
/*    */   public DataConfig(Element data) {
/* 21 */     this.maxRow = Integer.parseInt(data.attributeValue("maxRow"));
/* 22 */     this.dataA = new DataInterfaceConfig(data.element("dataA"));
/* 23 */     this.dataB = new DataInterfaceConfig(data.element("dataB"));
/*    */   }
/*    */ 
/*    */   
/* 27 */   public DataInterfaceConfig getDataA() { return this.dataA; }
/*    */ 
/*    */ 
/*    */   
/* 31 */   public DataInterfaceConfig getDataB() { return this.dataB; }
/*    */ 
/*    */ 
/*    */   
/* 35 */   public int getMaxRow() { return this.maxRow; }
/*    */ }


/* Location:              D:\Code\俄罗斯方块1.0\Tetris.jar!\config\DataConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */