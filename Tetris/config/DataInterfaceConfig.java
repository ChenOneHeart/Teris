/*    */ package config;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DataInterfaceConfig
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 8562324101650946264L;
/*    */   private final String className;
/*    */   private final Map<String, String> param;
/*    */   
/*    */   public DataInterfaceConfig(Element dataInterfaceConfig) {
/* 22 */     this.className = dataInterfaceConfig.attributeValue("className");
/* 23 */     this.param = new HashMap<>();
/*    */     
/* 25 */     List<Element> params = dataInterfaceConfig.elements("param");
/* 26 */     for (Element e : params) {
/* 27 */       this.param.put(e.attributeValue("key"), e.attributeValue("value"));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/* 32 */   public String getClassName() { return this.className; }
/*    */ 
/*    */ 
/*    */   
/* 36 */   public Map<String, String> getParam() { return this.param; }
/*    */ }


/* Location:              D:\Code\俄罗斯方块1.0\Tetris.jar!\config\DataInterfaceConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */