/*    */ package config;
/*    */ 
/*    */ import java.awt.Point;
/*    */ import java.io.Serializable;
/*    */ import java.util.ArrayList;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SystemConfig
/*    */   implements Serializable
/*    */ {
/*    */   private final int minX;
/*    */   private final int maxX;
/*    */   private final int minY;
/*    */   private final int maxY;
/*    */   private final int levelUp;
/*    */   private final List<Point[]> typeConfig;
/*    */   private final List<Boolean> typeRound;
/*    */   private final Map<Integer, Integer> plusPoint;
/*    */   
/*    */   public SystemConfig(Element system) {
/* 32 */     this.minX = Integer.parseInt(system.attributeValue("minX"));
/* 33 */     this.maxX = Integer.parseInt(system.attributeValue("maxX"));
/* 34 */     this.minY = Integer.parseInt(system.attributeValue("minY"));
/* 35 */     this.maxY = Integer.parseInt(system.attributeValue("maxY"));
/* 36 */     this.levelUp = Integer.parseInt(system.attributeValue("levelUp"));
/*    */     
/* 38 */     List<Element> rects = system.elements("rect");
/* 39 */     this.typeConfig = (List)new ArrayList<>(rects.size());
/* 40 */     this.typeRound = new ArrayList<>(rects.size());
/* 41 */     for (Element rect : rects) {
/*    */       
/* 43 */       this.typeRound.add(Boolean.valueOf(Boolean.parseBoolean(rect.attributeValue("round"))));
/*    */ 
/*    */       
/* 46 */       List<Element> pointConfig = rect.elements("point");
/*    */       
/* 48 */       Point[] points = new Point[pointConfig.size()];
/*    */       
/* 50 */       for (int i = 0; i < points.length; i++) {
/* 51 */         int x = Integer.parseInt(((Element)pointConfig.get(i)).attributeValue("x"));
/* 52 */         int y = Integer.parseInt(((Element)pointConfig.get(i)).attributeValue("y"));
/* 53 */         points[i] = new Point(x, y);
/*    */       } 
/*    */       
/* 56 */       this.typeConfig.add(points);
/*    */     } 
/*    */     
/* 59 */     this.plusPoint = new HashMap<>();
/*    */     
/* 61 */     List<Element> plusPointCfg = system.elements("plusPoint");
/* 62 */     for (Element cfg : plusPointCfg) {
/* 63 */       int rm = Integer.parseInt(cfg.attributeValue("rm"));
/* 64 */       int point = Integer.parseInt(cfg.attributeValue("point"));
/* 65 */       this.plusPoint.put(Integer.valueOf(rm), Integer.valueOf(point));
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/* 70 */   public int getMinX() { return this.minX; }
/*    */ 
/*    */ 
/*    */   
/* 74 */   public int getMaxX() { return this.maxX; }
/*    */ 
/*    */ 
/*    */   
/* 78 */   public int getMinY() { return this.minY; }
/*    */ 
/*    */ 
/*    */   
/* 82 */   public int getMaxY() { return this.maxY; }
/*    */ 
/*    */ 
/*    */   
/* 86 */   public List<Point[]> getTypeConfig() { return this.typeConfig; }
/*    */ 
/*    */ 
/*    */   
/* 90 */   public int getLevelUp() { return this.levelUp; }
/*    */ 
/*    */ 
/*    */   
/* 94 */   public List<Boolean> getTypeRound() { return this.typeRound; }
/*    */ 
/*    */ 
/*    */   
/* 98 */   public Map<Integer, Integer> getPlusPoint() { return this.plusPoint; }
/*    */ }


/* Location:              D:\Code\俄罗斯方块1.0\Tetris.jar!\config\SystemConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */