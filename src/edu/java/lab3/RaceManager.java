package edu.java.lab3;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class RaceManager {

	private JFrame raceList;
	private DefaultTableModel model;
	private JButton save;
	private JButton open;
	private JButton add;
	private JButton edit;
	private JButton delete;
	private JButton pedestal;
	private JToolBar toolBar;
	private JScrollPane scroll;
	private JTable race;
	private JComboBox team;
	private JTextField driver;
	private JButton filter;

	public void show() 
	{
		raceList = new JFrame("Список гонок");
		raceList.setSize(700, 500);
		raceList.setLocation(100, 100);
		raceList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		save = new JButton(new ImageIcon("./img/diskette.png"));
		open = new JButton(new ImageIcon("./img/open-file.png"));
		add = new JButton(new ImageIcon("./img/add (1).png"));
		edit = new JButton(new ImageIcon("./img/edit (1).png"));
		delete = new JButton(new ImageIcon("./img/minus.png"));
		pedestal = new JButton(new ImageIcon("./img/pedestal.png"));
		
		save.setToolTipText("Сохранить список");
		open.setToolTipText("Открыть список");
		add.setToolTipText("Добавить запись");
		edit.setToolTipText("Изменить запись");
		delete.setToolTipText("Удалить запись");
		pedestal.setToolTipText("Показать призеров");

		toolBar = new JToolBar("Панель инструментов");
		toolBar.add(add);
		toolBar.add(edit);
		toolBar.add(delete);
		toolBar.add(save);
		toolBar.add(open);
		toolBar.add(pedestal);
		
		raceList.setLayout(new BorderLayout());
		raceList.add(toolBar, BorderLayout.NORTH);
		
		String [] columnsRace = {"Команда","Пилот","Трасса","Дата и время","Место","Очки"};
		String [][] dataRace = {
			{"Red Bull Racing","Макс Ферстаппен","Спа-Франкоршам","28-08-2022 15:00","1","25"},
			{"Mercedes AMG Petronas","Льюис Хэмилтон","Сильверстоун","03-07-2022 15:00","2","18"},
			{"Ferrari","Шарль Леклер","Монако","29-05-2022 15:00","3","15"},
			{"McLaren","Ландо Норрис","Монца","11-09-2022 15:00","4","12"},
			{"AlphaTauri","Пьер Гасли","Будапешт","01-08-2022 15:00","5","10"},
			{"Aston Martin","Себастьян Феттель","Сочи","26-09-2022 15:00","6","8"},
			{"Alpine","Фернандо Алонсо","Барселона","22-05-2022 15:00","7","6"},
			{"Williams","Джордж Рассел","Зандворт","04-09-2022 15:00","8","4"},
			{"Haas","Мик Шумахер","Бахрейн","12-03-2022 15:00","9","2"  },
			{"Alfa Romeo","Валттери Боттас","Имола","24-04-2022 15:00","10","1"},
			{"Red Bull Racing","Серхио Перес","Мехико","30-10-2022 15:00","1","25"},
			{"Mercedes AMG Petronas","Джордж Рассел","Интерлагос","13-11-2022 15:00","2","18"},
			{"Ferrari","Карлос Сайнс","Сингапур","02-10-2022 15:00","3","15"},
			{"McLaren","Даниэль Риккардо","Шанхай","10-04-2022 15:00","4","12"},
			{"AlphaTauri","Юки Цунода","Сузука","09-10-2022 15:00","5","10"},
			{"Aston Martin","Лэнс Стролл","Баку","12-06-2022 15:00","6","8"},
			{"Alpine","Эстебан Окон","Монреаль","19-06-2022 15:00","7","6"},
			{"Williams","Николас Латифи","Абу-Даби","20-11-2022 15:00","8","4"},
			{"Haas","Кевин Магнуссен","Остин","23-10-2022 15:00","9","2"},
			{"Alfa Romeo","Гуаньюй Чжоу","Мельбурн","10-04-2022 15:00","10","1"}};
			model = new DefaultTableModel(dataRace, columnsRace);
			race = new JTable(model);
			scroll = new JScrollPane(race);
			raceList.add(scroll, BorderLayout.CENTER);
			
			team = new JComboBox(new String[]{"Команда",
			"McLaren", "Haas", "Alfa Romeo", "Williams", 
			"Red Bull Racing", "Aston Martin", "Alpine",
			"Mercedes AMG Petronas", "AlphaTauri", "Ferrari"}); 
			driver = new JTextField("Имя пилота");
			filter = new JButton("Поиск");
			JPanel filterPanel = new JPanel();
			filterPanel.add(team);
			filterPanel.add(driver);
			filterPanel.add(filter);
			
			raceList.add(filterPanel, BorderLayout.SOUTH);
			
			save.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					JOptionPane.showMessageDialog(raceList, "Успешно сохранено!", null, 1);
				}
			});
			open.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					JOptionPane.showMessageDialog(raceList, "Открыть список", null, 1);
				}
			});
			add.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					JOptionPane.showMessageDialog(raceList, "Добавить запись", null, 1);
				}
			});
			edit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					JOptionPane.showMessageDialog(raceList, "Изменить запись", null, 1);
				}
			});
			delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					JOptionPane.showMessageDialog(raceList, "Запись удалена", null, 1);
				}
			});
			pedestal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					JOptionPane.showMessageDialog(raceList, "Тройка лучших", null, 1);
				}
			});
			filter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					JOptionPane.showMessageDialog(raceList, "Поиск пилота", null, 1);
				}
			});

			raceList.setVisible(true);
		}
		
		public static void main(String[] args) {
			new RaceManager().show();
		}
		
	}
	