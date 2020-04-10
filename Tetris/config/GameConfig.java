/*    */ package config;
/*    */ 
/*    */ import java.io.FileInputStream;
/*    */ import java.io.ObjectInputStream;
/*    */ import java.io.Serializable;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GameConfig
/*    */   implements Serializable
/*    */ {
/* 26 */   private static FrameConfig FRAME_CONFIG = null;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 31 */   private static DataConfig DATA_CONFIG = null;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 36 */   private static SystemConfig SYSTEM_CONFIG = null;
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
/*    */   
/*    */   private static final boolean DEBUG = false;
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
/*    */   
/*    */   static  {
/*    */     try {
/* 62 */       ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data/framecfg.dat"));
/* 63 */       FRAME_CONFIG = (FrameConfig)ois.readObject();
/* 64 */       ois = new ObjectInputStream(new FileInputStream("data/systemCfg.dat"));
/* 65 */       SYSTEM_CONFIG = (SystemConfig)ois.readObject();
/* 66 */       ois = new ObjectInputStream(new FileInputStream("data/datacfg.dat"));
/* 67 */       DATA_CONFIG = (DataConfig)ois.readObject();
/* 68 */       ois.close();
/*    */     }
/* 70 */     catch (Exception e) {
/* 71 */       e.printStackTrace();
/*    */     } 
/*    */   }
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
/* 84 */   public static FrameConfig getFrameConfig() { return FRAME_CONFIG; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 91 */   public static SystemConfig getSystemConfig() { return SYSTEM_CONFIG; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 97 */   public static DataConfig getDataConfig() { return DATA_CONFIG; }
/*    */ }


/* Location:              D:\Code\俄罗斯方块1.0\Tetris.jar!\config\GameConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */