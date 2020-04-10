/*     */ package config;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FrameConfig
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -5023264200009692899L;
/*     */   private final String title;
/*     */   private final int windowUp;
/*     */   private final int width;
/*     */   private final int height;
/*     */   private final int padding;
/*     */   private final int boder;
/*     */   private final int sizeRol;
/*     */   private final int loseIdx;
/*     */   private final List<LayerConfig> layersConfig;
/*     */   private final ButtonConfig buttonConfig;
/*     */   
/*     */   public FrameConfig(Element frame) {
/*  44 */     this.width = Integer.parseInt(frame.attributeValue("width"));
/*     */     
/*  46 */     this.height = Integer.parseInt(frame.attributeValue("height"));
/*     */     
/*  48 */     this.boder = Integer.parseInt(frame.attributeValue("boder"));
/*     */     
/*  50 */     this.padding = Integer.parseInt(frame.attributeValue("padding"));
/*     */     
/*  52 */     this.title = frame.attributeValue("title");
/*     */     
/*  54 */     this.windowUp = Integer.parseInt(frame.attributeValue("windowUp"));
/*     */     
/*  56 */     this.sizeRol = Integer.parseInt(frame.attributeValue("sizeRol"));
/*     */     
/*  58 */     this.loseIdx = Integer.parseInt(frame.attributeValue("loseIdx"));
/*     */ 
/*     */     
/*  61 */     List<Element> layers = frame.elements("layer");
/*  62 */     this.layersConfig = new ArrayList<>();
/*     */     
/*  64 */     for (Element layer : layers) {
/*     */       
/*  66 */       LayerConfig lc = new LayerConfig(
/*  67 */           layer.attributeValue("className"), 
/*  68 */           Integer.parseInt(layer.attributeValue("x")), 
/*  69 */           Integer.parseInt(layer.attributeValue("y")), 
/*  70 */           Integer.parseInt(layer.attributeValue("w")), 
/*  71 */           Integer.parseInt(layer.attributeValue("h")));
/*     */       
/*  73 */       this.layersConfig.add(lc);
/*     */     } 
/*     */     
/*  76 */     this.buttonConfig = new ButtonConfig(frame.element("button"));
/*     */   }
/*     */ 
/*     */   
/*  80 */   public String getTitle() { return this.title; }
/*     */ 
/*     */ 
/*     */   
/*  84 */   public int getWindowUp() { return this.windowUp; }
/*     */ 
/*     */ 
/*     */   
/*  88 */   public int getWidth() { return this.width; }
/*     */ 
/*     */ 
/*     */   
/*  92 */   public int getHeight() { return this.height; }
/*     */ 
/*     */ 
/*     */   
/*  96 */   public int getPadding() { return this.padding; }
/*     */ 
/*     */ 
/*     */   
/* 100 */   public int getBoder() { return this.boder; }
/*     */ 
/*     */ 
/*     */   
/* 104 */   public List<LayerConfig> getLayersConfig() { return this.layersConfig; }
/*     */ 
/*     */ 
/*     */   
/* 108 */   public int getSizeRol() { return this.sizeRol; }
/*     */ 
/*     */ 
/*     */   
/* 112 */   public int getLoseIdx() { return this.loseIdx; }
/*     */ 
/*     */ 
/*     */   
/* 116 */   public ButtonConfig getButtonConfig() { return this.buttonConfig; }
/*     */ }


/* Location:              D:\Code\俄罗斯方块1.0\Tetris.jar!\config\FrameConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */