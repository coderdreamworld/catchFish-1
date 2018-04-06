package com.mypro.main;

import com.mypro.manager.CannonManager;
import com.mypro.manager.GameInitManager;
import com.mypro.manager.LayoutManager;
import com.mypro.model.GamingInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AwtMainComponet {
public static void main(String[] args) throws Exception {
    /**
     * ʹ���ھ��������ַ�����
     * 1������ͨ��toolkit��ȡ��Ļ��С�Ӷ�ʹ�ô��ھ���
     * 2������ͨ��setRelativeTo(null)�����λ��Ϊ��
     */
    Toolkit tool = Toolkit.getDefaultToolkit();
    Dimension d = tool.getScreenSize();

    JFrame frame = new JFrame();
    //��ʼ��GamingInfo
    GamingInfo.getGamingInfo().setGaming(true);
    GamingInfo.getGamingInfo().setScreenWidth(900);
    GamingInfo.getGamingInfo().setScreenHeight(600);

    frame.setSize(GamingInfo.getGamingInfo().getScreenWidth(), GamingInfo.getGamingInfo().getScreenHeight());
    //frame.setUndecorated(true); // ȥ�����ڵ�װ��
    frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);//����ָ���Ĵ���װ�η��
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //ʹ���ھ��еļ򵥷�����ֱ������relativeToΪnull
    frame.setLocationRelativeTo(null);
    MainSurface pane = new MainSurface();
    GamingInfo.getGamingInfo().setSurface(pane);
    frame.setContentPane(pane);
    //�Ƿ�ʹ����ʼ�������Ϸ�
    //frame.setAlwaysOnTop(true);
    frame.setVisible(true);
    frame.addMouseListener(new MouseListener() {
        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mousePressed(MouseEvent e) {
            //�����Ϸ��û��ʼ��ֱ�ӷ���
            if (GameInitManager.getGameInitManager().isIniting()) {
                return;
            }
            //��Ļ������
            //�ȿ����ֹ������Ƿ�����ӦĿ�꣬�����Ŀ�꣬�����ӵ�
            if (!LayoutManager.getLayoutManager().onClick(e.getX(), e.getY())) {
                //�����ӵ�
                CannonManager.getCannonManager().shot(e.getX(), e.getY());
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub

        }
    });
//		frame.pack();
    pane.action();
    /**
     * ����һ���߳����첽��ʼ����Ϸ����
     */
    new Thread(new Runnable() {

        public void run() {
            //ʹ����Ϸ��ʼ����������ʼ����Ϸ
            GameInitManager.getGameInitManager().init();
        }

    }).start();
}

}
