package com.yc.myproject.util;

import com.yc.myproject.domain.DO.Result;
import com.yc.myproject.enums.ResponseEnum;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * User: mcfell.yc
 * Date: 2017/9/14
 * Time: 下午8:06
 */
public class PrintWriterUtils {

    public static void print(HttpServletResponse response, String msg) throws IOException{
        PrintWriter writer = response.getWriter();
        writer.write(msg);
        writer.flush();
        writer.close();
    }

    public static void print(HttpServletResponse response, ResponseEnum msg) throws IOException{
        PrintWriter writer = response.getWriter();
        writer.write(String.valueOf(new Result<>(msg)));
        writer.flush();
        writer.close();
    }
}
