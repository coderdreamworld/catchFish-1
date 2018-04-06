package com.mypro.model.interfaces;

import com.mypro.graphics.Bitmap;
import com.mypro.graphics.Canvas;
import com.mypro.graphics.Matrix;
import com.mypro.graphics.Paint;

public interface Drawable {
Matrix getPicMatrix();//��ȡͼƬ��ת�ľ����ʾ

Bitmap getCurrentPic();//��ȡ��ǰ����ͼƬ����Դ

int getPicWidth();//����ͼƬ�Ŀ��

int getPicHeight();//����ͼƬ�ĸ߶�

void onDraw(Canvas canvas, Paint paint);//���ƵĻص�����
}
