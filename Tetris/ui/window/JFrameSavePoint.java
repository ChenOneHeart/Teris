/*     */ package ui.window;
/*     */ 
/*     */ import control.GameControl;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Color;
/*     */ import java.awt.FlowLayout;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ import util.FrameUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JFrameSavePoint
/*     */   extends JFrame
/*     */ {
/*  22 */   private JLabel lbpoint = null;
/*     */   
/*  24 */   private JTextField txName = null;
/*     */   
/*  26 */   private JButton btnOK = null;
/*     */   
/*  28 */   private JLabel errMsg = null;
/*     */   
/*  30 */   private GameControl gameControl = null;
/*     */   
/*     */   public JFrameSavePoint(GameControl gameControl) {
/*  33 */     this.gameControl = gameControl;
/*  34 */     setTitle("保存记录");
/*  35 */     setSize(256, 128);
/*  36 */     FrameUtil.setFrameCenter(this);
/*  37 */     setResizable(false);
/*  38 */     setLayout(new BorderLayout());
/*  39 */     createCom();
/*  40 */     crerteAction();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void showWindow(int point) {
/*  47 */     this.lbpoint.setText("您的得分" + point);
/*  48 */     setVisible(true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void crerteAction() {
/*  55 */     this.btnOK.addActionListener(new ActionListener()
/*     */         {
/*     */           public void actionPerformed(ActionEvent e) {
/*  58 */             String name = JFrameSavePoint.this.txName.getText();
/*  59 */             if (name.length() > 16 || name == null || "".equals(name)) {
/*  60 */               JFrameSavePoint.this.errMsg.setText("名字输入错误");
/*     */             } else {
/*  62 */               JFrameSavePoint.this.setVisible(false);
/*  63 */               JFrameSavePoint.this.gameControl.savePoint(name);
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void createCom() {
/*  74 */     JPanel north = new JPanel(new FlowLayout(0));
/*     */     
/*  76 */     this.lbpoint = new JLabel();
/*     */     
/*  78 */     north.add(this.lbpoint);
/*     */     
/*  80 */     this.errMsg = new JLabel();
/*  81 */     this.errMsg.setForeground(Color.RED);
/*     */     
/*  83 */     north.add(this.errMsg);
/*     */     
/*  85 */     add(north, "North");
/*     */     
/*  87 */     JPanel center = new JPanel(new FlowLayout(0));
/*     */     
/*  89 */     this.txName = new JTextField(10);
/*     */     
/*  91 */     center.add(new JLabel("请输入名称:"));
/*     */     
/*  93 */     center.add(this.txName);
/*     */     
/*  95 */     add(center, "Center");
/*     */     
/*  97 */     JPanel south = new JPanel(new FlowLayout(1));
/*     */     
/*  99 */     this.btnOK = new JButton("确定");
/*     */     
/* 101 */     south.add(this.btnOK);
/*     */     
/* 103 */     add(south, "South");
/*     */   }
/*     */ }


/* Location:              D:\Code\俄罗斯方块1.0\Tetris.jar\\ui\window\JFrameSavePoint.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */