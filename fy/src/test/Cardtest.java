package test;

import java.awt.Font;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class Cardtest {
	//�������б�
	private static ArrayList<Card> cardlist;

	// ��״ͼ����
	static ChartPanel frame1;
	static int x, y, n;

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// ����������Ϣ
		cardlist = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		File file = new File("E:\\����.txt");
		int k;
		String p, q;
		try {
			FileInputStream fis = new FileInputStream(file);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			String temp = null;

			while ((temp = in.readLine()) != null) {
				Scanner linescanner = new Scanner(temp);
				linescanner.useDelimiter(" ");
				String name = linescanner.next();
				String id = linescanner.next();
				String a = linescanner.next();
				String b = linescanner.next();
				String c = linescanner.next();
				String d = linescanner.next();
				String e = linescanner.next();
				String f = linescanner.next();
				String g = linescanner.next();

				String time = linescanner.nextLine();

				Card card = new Card();
				card.setName(name);
				card.setId(id);
				card.setA(a);
				card.setB(b);
				card.setC(c);
				card.setD(d);
				card.setE(e);
				card.setF(f);
				card.setG(g);

				card.setTime(time);

				cardlist.add(card);
				x = cardlist.size();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("��Ϣ�ļ��Ҳ���");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("��Ϣ�ļ���ȡ����");
			e.printStackTrace();
		}
		// �����������
		boolean isTrue = true;
		while (isTrue) {
			show();
			int nextInt = scanner.nextInt();
			switch (nextInt) {
			// 1.�г�������Ϣ
			case 1:
				title();
				System.out.println(cardlist.toString());
				break;
			// 2.�������ڲ鿴
			case 2:
				System.out.println("����ʱ�䣺");
				String time = scanner.next();

				p = time.substring(0, 9);
				k = 0;
				title();
				for (int i = 0; i < cardlist.size(); i++) {
					if (cardlist.get(i).getTime().substring(1, 10).equals(p)) {
						System.out.println(cardlist.get(i));
						k++;
					}
				}
				if (k == 0)
					System.out.println("�����޼�¼��");
				else
					System.out.println("��" + time + "����ͳ�Ƶ�����\n" + k);
				break;
			// 3.���������鿴
			case 3:
				System.out.println("����������");
				String name = scanner.next();
				p = name.substring(0, 3);
				k = 0;
				title();
				for (int i = 0; i < cardlist.size(); i++) {
					if (cardlist.get(i).getName().substring(0, 3).equals(p)) {
						System.out.println(cardlist.get(i));
						k++;
					}
				}
				if (k == 0)
					System.out.println("���޴��ˣ�");
				else
					System.out.println("������" + k + "����¼\n");
				break;
			// 4.����ѧ�Ų鿴
			case 4:
				System.out.println("����ѧ�ţ�");
				String id = scanner.next();
				p = id.substring(0, 12);
				k = 0;
				title();
				for (int i = 0; i < cardlist.size(); i++) {
					if (cardlist.get(i).getId().substring(0, 12).equals(p))
						System.out.println(cardlist.get(i));
					k++;
				}
				if (k == 0)
					System.out.println("ѧ�Ų����ڣ�");
				break;
			// 5.�鿴ĳ����ĳ������
			case 5:
				System.out.println("����ѧ��");
				String id1 = scanner.next();
				p = id1.substring(0, 12);
				System.out.println("��������");
				String time1 = scanner.next();
				q = time1.substring(0, 9);
				k = 0;
				title();
				for (int i = 0; i < cardlist.size(); i++) {
					if (cardlist.get(i).getId().substring(0, 12).equals(p)) {
						if (cardlist.get(i).getTime().substring(1, 10).equals(q)) {
							System.out.println(cardlist.get(i));
							k++;
						}
					}
				}
				if (k == 0)
					System.out.println("û�н��");
				break;
			// 6.����������鿴
			case 6: {
				System.out.println(
						"�������ѯ�ķ�����Ϣ��\"��ѡ�������(1.�Ƿ��ȣ�2.�Ƿ�Ϊ��Уѧ����3.�Ƿ��ں�����4.�Ƿ������������Ա�Ӵ���5.�Ƿ����人��6.�Ƿ����人������Ա�Ӵ���7.�����Ƿ����ط�У)");
				k = scanner.nextInt();
				switch (k) {
				case 1: {
					System.out.println("�Ƿ���");
					String a = scanner.next();
					p = a.substring(0, 1);
					n = 0;
					y = 0;

					if (a.equals("��")) {
						for (int i = 0; i < cardlist.size(); i++) {
							if (cardlist.get(i).getA().substring(0, 1).equals(p))
								y++;
						}
						System.out.println("��������Ϊ��" + y);
						n = x - y;
					}

					else if (a.equals("��")) {
						for (int i = 0; i < cardlist.size(); i++) {
							if (cardlist.get(i).getA().substring(0, 1).equals(p))
								n++;
						}
						System.out.println("δ��������Ϊ��" + n);
						y = x - n;
					}

					// ������״ͼ

					System.out.println("�Ƿ�Ҫ������״ͼ��");
					String b = scanner.next();

					if (b.equals("��")) {
						System.out.println("չʾ�����б�");

						Test();
						JFrame frame = new JFrame("�����ݵ�����ͳ��");
						frame.setLayout(new GridLayout(2, 2, 5, 5));
						frame.add(new Cardtest().getChartPanel()); // �������ͼ
						frame.setBounds(0, 0, 500, 400);
						frame.setVisible(true);
					} else if (b.equals("��")) {

						System.out.println("�˳���");

					}
					break;
				}
				case 2: {
					System.out.println("�Ƿ�Ϊ��Уѧ��");
					String a = scanner.next();
					p = a.substring(0, 1);
					n = 0;
					y = 0;
					if (a.equals("��")) {
						for (int i = 0; i < cardlist.size(); i++) {
							if (cardlist.get(i).getB().substring(0, 1).equals(p))
								y++;
						}
						System.out.println("��Уѧ������Ϊ��" + y);
						n = x - y;
					}

					else if (a.equals("��")) {
						for (int i = 0; i < cardlist.size(); i++) {
							if (cardlist.get(i).getB().substring(0, 1).equals(p))
								n++;
						}
						System.out.println("δ��Уѧ������Ϊ��" + n);
						y = x - n;
					}

					// ������״ͼ

					System.out.println("�Ƿ�Ҫ������״ͼ��");
					String b = scanner.next();

					if (b.equals("��")) {
						System.out.println("չʾ�����б�");
						Test();
						JFrame frame = new JFrame("�����ݵ�����ͳ��");
						frame.setLayout(new GridLayout(2, 2, 5, 5));
						frame.add(new Cardtest().getChartPanel()); // �������ͼ
						frame.setBounds(0, 0, 500, 400);
						frame.setVisible(true);
					} else if (b.equals("��")) {

						System.out.println("�˳���");

					}
					break;
				}
				case 3: {
					System.out.println("�Ƿ��ں���");
					String a = scanner.next();
					p = a.substring(0, 1);
					n = 0;
					y = 0;
					if (a.equals("��")) {
						for (int i = 0; i < cardlist.size(); i++) {
							if (cardlist.get(i).getC().substring(0, 1).equals(p))
								y++;
						}
						System.out.println("�ں�������Ϊ��" + y);
						n = x - y;
					}

					else if (a.equals("��")) {
						for (int i = 0; i < cardlist.size(); i++) {
							if (cardlist.get(i).getC().substring(0, 1).equals(p))
								n++;
						}
						System.out.println("���ں�������Ϊ��" + n);
						y = x - n;
					}

					// ������״ͼ

					System.out.println("�Ƿ�Ҫ������״ͼ��");
					String b = scanner.next();

					if (b.equals("��")) {
						System.out.println("չʾ�����б�");
						Test();
						JFrame frame = new JFrame("�����ݵ�����ͳ��");
						frame.setLayout(new GridLayout(2, 2, 5, 5));
						frame.add(new Cardtest().getChartPanel()); // �������ͼ
						frame.setBounds(0, 0, 500, 400);
						frame.setVisible(true);
					} else if (b.equals("��")) {

						System.out.println("�˳���");

					}
					break;
				}
				case 4: {
					System.out.println("�Ƿ������������Ա�Ӵ�");
					String a = scanner.next();
					p = a.substring(0, 1);
					n = 0;
					y = 0;
					if (a.equals("��")) {
						for (int i = 0; i < cardlist.size(); i++) {
							if (cardlist.get(i).getD().substring(0, 1).equals(p))
								y++;
						}
						System.out.println("�����������Ա�Ӵ�����Ϊ��" + y);
						n = x - y;
					}

					else if (a.equals("��")) {
						for (int i = 0; i < cardlist.size(); i++) {
							if (cardlist.get(i).getD().substring(0, 1).equals(p))
								n++;
						}
						System.out.println("δ�����������Ա�Ӵ�����Ϊ��" + n);
						y = x - n;
					}

					// ������״ͼ

					System.out.println("�Ƿ�Ҫ������״ͼ��");
					String b = scanner.next();

					if (b.equals("��")) {
						System.out.println("չʾ�����б�");
						Test();
						JFrame frame = new JFrame("�����ݵ�����ͳ��");
						frame.setLayout(new GridLayout(2, 2, 5, 5));
						frame.add(new Cardtest().getChartPanel()); // �������ͼ
						frame.setBounds(0, 0, 500, 400);
						frame.setVisible(true);
					} else if (b.equals("��")) {

						System.out.println("�˳���");

					}
					break;
				}
				case 5: {
					System.out.println("�Ƿ����人");
					String a = scanner.next();
					p = a.substring(0, 1);
					n = 0;
					y = 0;
					if (a.equals("��")) {
						for (int i = 0; i < cardlist.size(); i++) {
							if (cardlist.get(i).getE().substring(0, 1).equals(p))
								y++;
						}
						System.out.println("���人����Ϊ��" + y);
						n = x - y;
					}

					else if (a.equals("��")) {
						for (int i = 0; i < cardlist.size(); i++) {
							if (cardlist.get(i).getE().substring(0, 1).equals(p))
								n++;
						}
						System.out.println("�����人����Ϊ��" + n);
						y = x - n;
					}

					// ������״ͼ

					System.out.println("�Ƿ�Ҫ������״ͼ��");
					String b = scanner.next();

					if (b.equals("��")) {
						System.out.println("չʾ�����б�");
						Test();
						JFrame frame = new JFrame("�����ݵ�����ͳ��");
						frame.setLayout(new GridLayout(2, 2, 5, 5));
						frame.add(new Cardtest().getChartPanel()); // �������ͼ
						frame.setBounds(0, 0, 500, 400);
						frame.setVisible(true);
					} else if (b.equals("��")) {

						System.out.println("�˳���");

					}
					break;
				}
				case 6: {
					System.out.println("�Ƿ����人������Ա�Ӵ�");
					String a = scanner.next();
					p = a.substring(0, 1);
					n = 0;
					y = 0;
					if (a.equals("��")) {
						for (int i = 0; i < cardlist.size(); i++) {
							if (cardlist.get(i).getF().substring(0, 1).equals(p))
								y++;
						}
						System.out.println("���人������Ա�Ӵ�����Ϊ��" + y);
						n = x - y;
					}

					else if (a.equals("��")) {
						for (int i = 0; i < cardlist.size(); i++) {
							if (cardlist.get(i).getF().substring(0, 1).equals(p))
								n++;
						}
						System.out.println("δ���人������Ա�Ӵ�����Ϊ��" + n);
						y = x - n;
					}

					// ������״ͼ

					System.out.println("�Ƿ�Ҫ������״ͼ��");
					String b = scanner.next();

					if (b.equals("��")) {
						System.out.println("չʾ�����б�");
						Test();
						JFrame frame = new JFrame("�����ݵ�����ͳ��");
						frame.setLayout(new GridLayout(2, 2, 5, 5));
						frame.add(new Cardtest().getChartPanel()); // �������ͼ
						frame.setBounds(0, 0, 500, 400);
						frame.setVisible(true);
					} else if (b.equals("��")) {

						System.out.println("�˳���");

					}
					break;
				}

				case 7: {
					System.out.println("�����Ƿ����ط�У");
					String a = scanner.next();
					p = a.substring(0, 1);
					n = 0;
					y = 0;
					if (a.equals("��")) {
						for (int i = 0; i < cardlist.size(); i++) {
							if (cardlist.get(i).getG().substring(0, 1).equals(p))
								y++;
						}
						System.out.println("�������ط�У����Ϊ��" + y);
						n = x - y;
					}

					else if (a.equals("��")) {
						for (int i = 0; i < cardlist.size(); i++) {
							if (cardlist.get(i).getG().substring(0, 1).equals(p))
								n++;
						}
						System.out.println("����δ����ط�У����Ϊ��" + n);
						y = x - n;
					}

					// ������״ͼ

					System.out.println("�Ƿ�Ҫ������״ͼ��");
					String b = scanner.next();

					if (b.equals("��")) {
						System.out.println("չʾ�����б�");
						Test();
						JFrame frame = new JFrame("�����ݵ�����ͳ��");
						frame.setLayout(new GridLayout(2, 2, 5, 5));
						frame.add(new Cardtest().getChartPanel()); // �������ͼ
						frame.setBounds(0, 0, 500, 400);
						frame.setVisible(true);
					} else if (b.equals("��")) {

						System.out.println("�˳���");

					}
					break;
				}
				}
				break;
			}
			// �˳�����
			case 7:
				isTrue = false;
				System.out.println("�������˳�!");
				break;
			default:
				System.out.println("��������");
			}
		}

	}

	// ϵͳ���˵�
	private static void show() {
		// TODO �Զ����ɵķ������
		System.out.println("��ӭ���������ѯϵͳ,��ѡ����Ĳ���");
		System.out.println("1.�г�������Ϣ");
		System.out.println("2.�������ڲ鿴");
		System.out.println("3.���������鿴");
		System.out.println("4.����ѧ�Ų鿴");
		System.out.println("5.����ѧ�š����ڲ鿴");
		System.out.println("6.����������鿴");
		System.out.println("7.�˳�");
	}

	// ������Ϣ
	private static void title() {
		// TODO �Զ����ɵķ������
		System.out.println("����\tѧ��\t���޷���\t�Ƿ�Ϊ��Уѧ��\t�Ƿ��ں���\t�Ƿ������������Ա�Ӵ�\t�Ƿ����人\t�Ƿ����人������Ա�Ӵ�\t�Ƿ�������ط�У ʱ��");

	}

	// ������״ͼ
	private static void Test() {
		// TODO �Զ����ɵķ������
		CategoryDataset dataset = getDataSet();// ����õ����ݴ��ݸ�CategoryDataset��Ķ���
		JFreeChart chart = ChartFactory.createBarChart3D("����ͳ�Ʊ�", // ͼ�����
				"������Ϣ", // Ŀ¼�����ʾ��ǩ
				"����/��", // ��ֵ�����ʾ��ǩ
				dataset, // ���ݼ�
				PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ
				true, // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������false)
				false, // �Ƿ����ɹ���
				false // �Ƿ�����URL����
		);

		CategoryPlot plot = chart.getCategoryPlot();// ��ȡͼ���������
		CategoryAxis domainAxis = plot.getDomainAxis(); // ˮƽ�ײ��б�
		domainAxis.setLabelFont(new Font("����", Font.BOLD, 14)); // ˮƽ�ײ�����
		domainAxis.setTickLabelFont(new Font("����", Font.BOLD, 12)); // ��ֱ����
		ValueAxis rangeAxis = plot.getRangeAxis();// ��ȡ��״
		rangeAxis.setLabelFont(new Font("����", Font.BOLD, 15));
		chart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));
		chart.getTitle().setFont(new Font("����", Font.BOLD, 20));// ���ñ�������

		frame1 = new ChartPanel(chart, true); // ����Ҳ������chartFrame,����ֱ������һ��������Frame

	}

	private static CategoryDataset getDataSet() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(y, "��", "��");
		dataset.addValue(n, "��", "��");
		return dataset;
	}

	public ChartPanel getChartPanel() {
		return frame1;

	}
}
