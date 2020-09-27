package type;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;



public class CheckCode {
	private final int width = 100;		// ����ͼƬ��width
	private final int height = 30;		// ����ͼƬ��height
	private final int codeCount = 4;	// ����ͼƬ����ʾ��֤��ĸ���
	//	private final int codeX = 15;		//����x�������,�������
	private final int fontHeight = 18;	//����߶�
	//	private final int codeY = 16;		//y����	
	private final int lineInfect = 0;
	private final float yawpRate = 0.01f;	//���������ͼ�еĸ��Ƿ�Χ5%
	private final int fontColor = 200; 	//������ɫ��Χ,ԽС��ɫԽ��(0-255)
	private final char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
			'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };


	public static void main(String args[])
	{
//		CheckCode cc=new CheckCode();
//		Map<String,Object> yzm=cc.generateCodeAndPic();
//		req.getSession().setAttribute("checkcode",((StringBuffer)yzm.get("code")).toString());
//		ImageIO.write((BufferedImage)yzm.get("codePic"), "jpg", resp.getOutputStream());
	}
	
	public Map<String,Object> m1;
	/**
	 * ����һ��map����
	 * codeΪ���ɵ���֤��
	 * codePicΪ���ɵ���֤��BufferedImage����
	 * @return
	 */

	public Map<String,Object> generateCodeAndPic() {
		// ����ͼ��buffer
		BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// Graphics2D gd = buffImg.createGraphics();
		// Graphics2D gd = (Graphics2D) buffImg.getGraphics();
		Graphics gd = buffImg.getGraphics();
		// ����һ���������������
		Random random = new Random();
		// ��ͼ�����Ϊ��ɫ
		gd.setColor(Color.WHITE);
		gd.fillRect(0, 0, width, height);


		// randomCode���ڱ��������������֤�룬�Ա��û���¼�������֤��
		StringBuffer randomCode = new StringBuffer();
		int red = 0, green = 0, blue = 0;
		// �������壬����Ĵ�СӦ�ø���ͼƬ�ĸ߶�������
		Font font = new Font("Fixedsys", Font.BOLD, fontHeight);
		// �������塣
		gd.setFont(font);
		// �������codeCount���ֵ���֤�롣
		for (int i = 0; i < codeCount; i++) {
			// �õ������������֤�����֡�
			String code = String.valueOf(codeSequence[random.nextInt(36)]);
			// �����������ɫ������������ɫֵ�����������ÿλ���ֵ���ɫֵ������ͬ��
			red = random.nextInt(fontColor);
			green = random.nextInt(fontColor);
			blue = random.nextInt(fontColor);

			// �������������ɫ����֤����Ƶ�ͼ���С�
			gd.setColor(new Color(red, green, blue));
			//��ת����
			Random rand = new Random();
			// ��������ַ���ת�Ƕ�(-30~30��)
			int degree = rand.nextInt(60);
			if (degree > 30)
				degree = 30 - degree;
			Graphics2D g2=(Graphics2D) gd.create();
			g2.translate(width/codeCount*(i)+5+rand.nextInt(5),height/2+5+rand.nextInt(5));
			g2.rotate( degree* Math.PI / 180);
			g2.drawString(code, 0, 0);
			// ���������ĸ�����������һ��
			randomCode.append(code);
		}
		//-------------------------------------------------
		//Ť��ͼƬ
		//Ť��X
//		int period = random.nextInt(2);
//		int fc=200,bc=250;
//		boolean borderGap = false;
//		int frames = 1;
//		int phase = random.nextInt(2);
//		Color color;
//
//		for (int i = 0; i < height; i++) {
//			double d = (double) (period >> 1) * Math.sin((double) i / (double) period + (6.2831853071795862D * (double) phase) / (double) frames);
//			gd.copyArea(0, i, width, 1, (int) d, 0);
//			if (borderGap) {
//				int r = fc + random.nextInt(bc - fc);
//				int g = fc + random.nextInt(bc - fc);
//				int b = fc + random.nextInt(bc - fc);
//				color=new Color(r, g, b);
//				gd.setColor(color);
//				gd.drawLine((int) d, i, 0, i);
//				gd.drawLine((int) d + width, i, width, i);
//			}
//		}
//		//Ť��Y
//		period = random.nextInt(10) + 5; // 50;
//		borderGap = false;
//		frames = 20;
//		phase = 3;
//		for (int i = 0; i < width; i++) {
//			double d = (double) (period >> 1) * Math.sin((double) i / (double) period + (6.2831853071795862D * (double) phase) / (double) frames);
//			gd.copyArea(i, 0, 1, height, 0, (int) d);
//			if (borderGap) {
//				int r = fc + random.nextInt(bc - fc);
//				int g = fc + random.nextInt(bc - fc);
//				int b = fc + random.nextInt(bc - fc);
//				color=new Color(r, g, b);
//				gd.setColor(color);
//				gd.drawLine(i, (int) d, i, 0);
//				gd.drawLine(i, (int) d + height, i, height);
//			}
//
//		}
		//-------------------------------------------------

		// ���߿�
		gd.setColor(Color.BLACK);
		gd.drawRect(0, 0, width - 1, height - 1);
		//-------------------------------------------------
		// �������30�������ߣ�ʹͼ���е���֤�벻�ױ���������̽�⵽��
		gd.setColor(Color.BLACK);
		for (int i = 0; i < lineInfect; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			gd.drawLine(x, y, x + xl, y + yl);
		}
		//-------------------------------------------------
		//�������

		int area = (int) (yawpRate * width * height);

		for (int i= 0; i < area; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int[] rgb =  new int[3];
			for (int j = 0; j < 3; j++) {
				rgb[j] = random.nextInt(255);
			}
			int color1 = 0;
			for (int c : rgb) {
				color1 = color1 << 8;
				color1 = color1 | c;
			}
			buffImg.setRGB(x, y, color1);
		}
		Map<String,Object> map  =new HashMap<String,Object>();
		//�����֤��
		map.put("code", randomCode);
		//������ɵ���֤��BufferedImage����
		map.put("codePic", buffImg);
		return map;
	}



}
