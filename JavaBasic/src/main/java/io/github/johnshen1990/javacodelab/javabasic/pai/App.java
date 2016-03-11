package io.github.johnshen1990.javacodelab.javabasic.pai;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Author: zhun.shen
 * Date: 2016-03-11 11:09
 * Description:
 */
public class App {
    final static int scale = 15000000;
    final static int pix = 1000;

    // 判断一个点是否在圆内
    public static boolean isInCircle(Point point){
        BigDecimal x = point.getX();
        BigDecimal y = point.getY();
        double distance = Math.sqrt(x.add(BigDecimal.valueOf(-(pix/2))).pow(2).add(y.add(BigDecimal.valueOf(-(pix / 2))).pow(2)).doubleValue());
        return distance <= pix/2;
    }

    public static void main(String[] args) {

        java.util.List<Point> inCirclePointList = new ArrayList<>();
        java.util.List<Point> outCirclePointList = new ArrayList<>();

        for(int i=0; i < scale; i++){
            // 随机生成一个点
            Point point = Utils.generatePoint(pix);
            if(isInCircle(point)) inCirclePointList.add(point);
            else outCirclePointList.add(point);
        }

        System.out.println("pai=" + BigDecimal.valueOf(inCirclePointList.size() * 4).divide(BigDecimal.valueOf(scale)));



        try
        {
            // 创建BufferedImage对象
            BufferedImage image = new BufferedImage(pix, pix,BufferedImage.TYPE_INT_RGB);
            // 获取Graphics2D
            Graphics2D g2d = image.createGraphics();
            // 画图
            g2d.setBackground(new Color(255,255,255));
            g2d.setPaint(new Color(0,0,0));
            g2d.clearRect(0, 0, pix, pix);

            for(Point point : inCirclePointList){
                int x = point.getX().intValue();
                int y = point.getY().intValue();
//                System.out.println("(" + x + "," + y + ")");
                g2d.drawLine(x, y, x, y);
            }

//            System.out.println("---------------------------");

            g2d.setPaint(new Color(204,0,0));
            for(Point point : outCirclePointList){
                int x = point.getX().intValue();
                int y = point.getY().intValue();
//                System.out.println("(" + x + "," + y + ")");
                g2d.drawLine(x, y, x, y);
            }


            //释放对象
            g2d.dispose();
            // 保存文件
            ImageIO.write(image, "png", new File("/Users/john/test.png"));
            System.out.println("hello");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

    }
}
