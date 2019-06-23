package com.example.checkcode.controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by xianpeng.xia
 * on 2019-06-23 09:18
 */
@org.springframework.stereotype.Controller
public class Controller {

    ThreadLocalRandom random = ThreadLocalRandom.current();

    @RequestMapping(value = "/index")
    public ModelAndView test(ModelAndView mv) throws IOException {
        mv.setViewName("/index");
        mv.addObject("title", "welcome !");
        return mv;
    }

    @RequestMapping("/getCheckCode")
    public void getCheckCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        getImage(request, response);
    }

    public void getImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedImage bufferedImage = new BufferedImage(68, 22, BufferedImage.TYPE_INT_BGR);
        Graphics graphics = bufferedImage.getGraphics();
        Color color = new Color(200, 150, 255);
        graphics.setColor(color);
        graphics.fillRect(0, 0, 68, 22);

        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        int len = chars.length;
        int index;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            index = random.nextInt(len);
            graphics.setColor(new Color(random.nextInt(88), random.nextInt(188), random.nextInt(255)));
            graphics.drawString(chars[index] + "", (i * 15) + 3, 18);
            sb.append(chars[index]);
        }
        request.getSession().setAttribute("piccode", sb.toString());
        ImageIO.write(bufferedImage, "JPG", response.getOutputStream());
        response.getOutputStream().flush();
        response.getOutputStream().close();
    }
}
