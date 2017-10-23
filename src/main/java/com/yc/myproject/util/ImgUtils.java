package com.yc.myproject.util;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * User: mcfell.yc
 * Date: 2017/10/12
 * Time: 下午3:21
 */
public class ImgUtils {

    public static void reduceImg(InputStream inputStream, String imgdist, int widthdist,
                                 int heightdist, Float rate) {
        FileOutputStream out = null;
        try {
            // 检查文件是否存在
            // 如果rate不为空说明是按比例压缩
            if (rate != null && rate > 0) {
                // 获取文件高度和宽度
                int[] results = getImgWidth(inputStream);
                if (results == null || results[0] == 0 || results[1] == 0) {
                    return;
                } else {
                    widthdist = (int) (results[0] * rate);
                    heightdist = (int) (results[1] * rate);
                }
            }
            long start = System.currentTimeMillis();
            // 开始读取文件并进行压缩
            Image src = javax.imageio.ImageIO.read(inputStream);
            BufferedImage tag = new BufferedImage((int) widthdist,
                    (int) heightdist, BufferedImage.TYPE_INT_RGB);

            tag.getGraphics().drawImage(
                    src.getScaledInstance(widthdist, heightdist,
                            Image.SCALE_SMOOTH), 0, 0, null);

            out = new FileOutputStream(imgdist);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            encoder.encode(tag);
            System.out.println("cost:"+(System.currentTimeMillis() - start));
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                out.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 采用指定宽度、高度或压缩比例 的方式对图片进行压缩
     * @param imgsrc 源图片地址
     * @param imgdist 目标图片地址
     * @param widthdist 压缩后图片宽度（当rate==null时，必传）
     * @param heightdist 压缩后图片高度（当rate==null时，必传）
     * @param rate 压缩比例
     */
    public static void reduceImg(String imgsrc, String imgdist, int widthdist,
                                 int heightdist, Float rate) {
        try {
            File srcfile = new File(imgsrc);
            // 检查文件是否存在
            if (!srcfile.exists()) {
                return;
            }
            // 如果rate不为空说明是按比例压缩
            if (rate != null && rate > 0) {
                // 获取文件高度和宽度
                int[] results = getImgWidth(srcfile);
                if (results == null || results[0] == 0 || results[1] == 0) {
                    return;
                } else {
                    widthdist = (int) (results[0] * rate);
                    heightdist = (int) (results[1] * rate);
                }
            }
            long start = System.currentTimeMillis();
            // 开始读取文件并进行压缩
            Image src = javax.imageio.ImageIO.read(srcfile);
            BufferedImage tag = new BufferedImage((int) widthdist,
                    (int) heightdist, BufferedImage.TYPE_INT_RGB);

            tag.getGraphics().drawImage(
                    src.getScaledInstance(widthdist, heightdist,
                            Image.SCALE_SMOOTH), 0, 0, null);

            FileOutputStream out = new FileOutputStream(imgdist);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            encoder.encode(tag);
            out.close();
            System.out.println("cost:"+(System.currentTimeMillis() - start));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 获取图片宽度
     *
     * @param file
     *            图片文件
     * @return 宽度
     */
    public static int[] getImgWidth(File file) {
        InputStream is = null;
        BufferedImage src = null;
        int result[] = { 0, 0 };
        try {
            is = new FileInputStream(file);
            src = javax.imageio.ImageIO.read(is);
            result[0] = src.getWidth(null); // 得到源图宽
            result[1] = src.getHeight(null); // 得到源图高
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int[] getImgWidth(InputStream is) {
        BufferedImage src = null;
        int result[] = { 0, 0 };
        try {
            src = javax.imageio.ImageIO.read(is);
            result[0] = src.getWidth(null); // 得到源图宽
            result[1] = src.getHeight(null); // 得到源图高
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        /**
         * d://3.jpg 源图片
         * d://31.jpg 目标图片
         * 压缩宽度和高度都是1000
         *
         */
        String orgin = "/Users/mcfell/Documents/workfile/OwnProject/webtest/upload-dir/DingTalk20171012153637.png";
        String dest  = "/Users/mcfell/Documents/workfile/OwnProject/webtest/upload-dir/DingTalk20171012153637_1400_800.png";
        System.out.println("压缩图片开始...");
        File srcfile = new File(orgin);
        System.out.println("压缩前srcfile size:" + srcfile.length());
        reduceImg(orgin,dest, 1400, 800,5.0f);
        File distfile = new File(dest);
        System.out.println("压缩后distfile size:" + distfile.length());

    }
}
