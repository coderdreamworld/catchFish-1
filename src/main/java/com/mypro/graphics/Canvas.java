package com.mypro.graphics;

/*
 * ����
 */
public interface Canvas {
void drawBitmap(Bitmap bitmap, Matrix matrix, Paint paint);
void drawBitmap(Bitmap bitmap, float x, float y, Paint paint);
}
