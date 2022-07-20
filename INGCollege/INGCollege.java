
/**
 * 
 * Name: Aaditya Chualagain (L1N1)
 * London Met. ID: 20049120
 * College ID: NP01NT4S210108
 * 
 */

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class INGCollege {

    private JFrame frame;
    private JTextField courseID;
    private JTextField courseName;
    private JTextField duration;
    private JTextField level;
    private JTextField credit;
    private JTextField numberOfAssessments;
    private JTextField courseLeader;
    private JTextField lecturerName;
    private JTextField startingDate;
    private JTextField completionDate;
    private JTable table;

    private JTextField courseID2;
    private JTextField courseName2;
    private JTextField duration2;
    private JTextField prerequisite;
    private JTextField courseLeader2;
    private JTextField instructorName;
    private JTextField startingDate2;
    private JTextField completionDate2;
    private JTextField courseIDRemove;
    private JTable table2;

    int row, row2;
    ArrayList<AcademicCourse> courseList;

    ArrayList<NonAcademicCourse> courseList2;

    DefaultTableModel tblModel;
    DefaultTableModel tblModel2;
    String header[] = new String[] { "Course ID", "Course Name", "Duration", "Level", "Credit", "Number of Assessments",
            "Course Leader", "Lecturer Name", "Starting Date", "Completion Date" };

    String header2[] = new String[] { "Course ID", "Course Name", "Duration", "Prerequisite", "Course Leader",
            "Instructor Name", "Starting Date", "Completion Date" };

    ArrayList<String> courseIDArray1 = new ArrayList<>();
    ArrayList<String> courseIDArray = new ArrayList<>();
    int count = 0;
    boolean status = false;
    boolean status2 = false;

    /**
     * Main method to run the program
     */

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    INGCollege frameWindow = new INGCollege();
                    frameWindow.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void displayCourseDetails() {
        tblModel.setRowCount(0);
        tblModel2.setRowCount(0);
        for (int i = 0; i < courseList.size(); i++) {
            Object[] obj = { courseList.get(i).courseID, courseList.get(i).courseName, courseList.get(i).duration,
                    courseList.get(i).level, courseList.get(i).credit, courseList.get(i).numberOfAssessments,
                    courseList.get(i).courseLeader, courseList.get(i).lecturerName, courseList.get(i).startingDate,
                    courseList.get(i).completionDate };
            tblModel.addRow(obj);

        }

        for (int j = 0; j < courseList2.size(); j++) {
            Object[] obj2 = { courseList2.get(j).courseID2, courseList2.get(j).courseName2,
                    courseList2.get(j).duration2, courseList2.get(j).prerequisite, courseList2.get(j).courseLeader2,
                    courseList2.get(j).instructorName, courseList2.get(j).startingDate2,
                    courseList2.get(j).completionDate2 };
            tblModel2.addRow(obj2);
        }
    }

    /**
     * Create class INGCollege
     */
    public INGCollege() {
        initialize();
        courseList = new ArrayList<>();
        tblModel = new DefaultTableModel(header, 0);
        table.setModel(tblModel);

        courseList2 = new ArrayList<>();
        tblModel2 = new DefaultTableModel(header2, 0);
        table2.setModel(tblModel2);
    }

    /**
     * Initialize the contents of the Jframe.
     */
    private void initialize() {
        frame = new JFrame("Course Registration");
        frame.getContentPane();
        frame.setSize(1100, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        // Welcome Message Panel Position
        JPanel welcomeMSG = new JPanel();
        welcomeMSG.setBounds(0, 0, 300, 560);
        welcomeMSG.setBackground(Color.decode("#D3D3D3"));
        welcomeMSG.setBorder(new EmptyBorder(10, 10, 10, 10));
        // Welcome Message Panel contents
        Font msgFont = new Font("", Font.BOLD, 25);

        JLabel message = new JLabel("!!!WELCOME!!!");
        message.setBounds(60, 25, 200, 50);
        message.setFont(msgFont);
        message.setForeground(Color.BLUE);
        welcomeMSG.add(message);

        try {

            ImageIcon img = new ImageIcon("Logo1.png");
            JLabel lblImage = new JLabel();
            lblImage.setIcon(img);
            welcomeMSG.add(lblImage);

            ImageIcon space = new ImageIcon("Space.png");
            JLabel lblSpace = new JLabel();
            lblSpace.setIcon(space);
            welcomeMSG.add(lblSpace);

            ImageIcon img2 = new ImageIcon("Logo2.png");
            JLabel lblImage2 = new JLabel();
            lblImage2.setIcon(img2);
            welcomeMSG.add(lblImage2);

        } catch (Exception e) {
            System.err.println("Image Not Found!!");
        }

        welcomeMSG.setVisible(true);

        frame.add(welcomeMSG);

        // welcomeMSG.setLayout(null);

        JLabel cr = new JLabel("Designed by Aaditya Chaulagain");
        // cr.setBounds(60, 480, 300, 100);

        cr.setForeground(Color.RED);
        welcomeMSG.add(cr);

        // Panel in the top position
        JPanel topBody = new JPanel();
        topBody.setBounds(301, 0, 782, 38);
        // topBody.setBackground(Color.decode("#DDDDDD"));
        frame.add(topBody);

        JPanel panel1 = new JPanel();
        // panel1.add(ta);
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JTabbedPane tabs = new JTabbedPane();
        tabs.setBounds(301, 35, 782, 525);
        tabs.setBackground(Color.GRAY);
        tabs.setForeground(Color.WHITE);

        // Setting tabs font
        Font myFont = new Font("", Font.BOLD, 14);
        tabs.setFont(myFont);
        tabs.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.GRAY));
        tabs.add("Academic Course", panel1);
        tabs.add("Non-Academic Course", panel2);

        frame.add(tabs);

        panel1.setLayout(null);
        panel2.setLayout(null);

        // Title for Academic Courses JTabbedPane
        JLabel academicHeaderText = new JLabel("Academic Course Registration Form");
        academicHeaderText.setBounds(190, 2, 800, 37);
        academicHeaderText.setFont(new Font("Arial", Font.BOLD, 22));

        JPanel headerPanel = new JPanel();
        headerPanel.setBounds(0, 0, 800, 37);
        headerPanel.setBackground(Color.decode("#DDDDDD"));
        panel1.add(headerPanel);
        headerPanel.add(academicHeaderText);
        headerPanel.setLayout(null);

        // Academic Course Panel 1
        JPanel academicPanel1 = new JPanel();
        academicPanel1.setBounds(0, 40, 800, 183);
        academicPanel1.setBackground(Color.decode("#B2B1B9"));
        panel1.add(academicPanel1);
        academicPanel1.setLayout(null);

        // Non-Academic Course Panel 1
        JPanel nonAcademicPanel1 = new JPanel();
        nonAcademicPanel1.setBounds(0, 40, 550, 183);
        nonAcademicPanel1.setBackground(Color.decode("#B2B1B9"));
        panel2.add(nonAcademicPanel1);
        nonAcademicPanel1.setLayout(null);

        // Academic Course Panel 2
        JPanel academicPanel2 = new JPanel();
        academicPanel2.setBounds(0, 226, 800, 183);
        academicPanel2.setBackground(Color.decode("#B2B1B9"));
        panel1.add(academicPanel2);
        academicPanel2.setLayout(null);

        // Non-Academic Course Panel 2
        JPanel nonAcademicPanel2 = new JPanel();
        nonAcademicPanel2.setBounds(0, 226, 800, 183);
        nonAcademicPanel2.setBackground(Color.decode("#B2B1B9"));
        panel2.add(nonAcademicPanel2);
        nonAcademicPanel2.setLayout(null);

        // Academic Course Panel 3
        JPanel academicPanel3 = new JPanel();
        academicPanel3.setBounds(0, 412, 350, 100);
        academicPanel3.setBackground(Color.decode("#B2B1B9"));
        panel1.add(academicPanel3);
        academicPanel3.setLayout(null);

        // Non-Academic Course Panel 3
        JPanel nonAcademicPanel3 = new JPanel();
        nonAcademicPanel3.setBounds(0, 412, 350, 100);
        nonAcademicPanel3.setBackground(Color.decode("#B2B1B9"));
        panel2.add(nonAcademicPanel3);
        nonAcademicPanel3.setLayout(null);

        // Academic Course Panel 4
        JPanel academicPanel4 = new JPanel();
        academicPanel4.setBounds(352, 412, 800, 100);
        academicPanel4.setBackground(Color.decode("#B2B1B9"));
        panel1.add(academicPanel4);
        academicPanel4.setLayout(null);

        // Non-Academic Course Panel 4
        JPanel nonAcademicPanel4 = new JPanel();
        nonAcademicPanel4.setBounds(552, 40, 300, 183);
        nonAcademicPanel4.setBackground(Color.decode("#B2B1B9"));
        panel2.add(nonAcademicPanel4);
        nonAcademicPanel4.setLayout(null);

        // Non-Academic Course Panel 5
        JPanel nonAcademicPanel5 = new JPanel();
        nonAcademicPanel5.setBounds(352, 412, 800, 100);
        nonAcademicPanel5.setBackground(Color.decode("#B2B1B9"));
        panel2.add(nonAcademicPanel5);
        nonAcademicPanel5.setLayout(null);

        // Title for Non-Academic Courses JTabbedPane
        JLabel nonAcademicHeaderText = new JLabel("Non-Academic Course Registration Form");
        nonAcademicHeaderText.setBounds(190, 2, 800, 37);
        nonAcademicHeaderText.setFont(new Font("Arial", Font.BOLD, 22));

        JPanel headerPanel2 = new JPanel();
        headerPanel2.setBounds(0, 0, 800, 37);
        headerPanel2.setBackground(Color.decode("#DDDDDD"));
        panel2.add(headerPanel2);
        headerPanel2.add(nonAcademicHeaderText);
        headerPanel2.setLayout(null);

        // CourseID lable for Academic Courses
        JLabel lblCourseID = new JLabel("CourseID");
        lblCourseID.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblCourseID.setBounds(40, 10, 100, 30);
        academicPanel1.add(frame.getContentPane().add(lblCourseID));

        //// CourseID lable for Non-Academic Courses
        JLabel lblCourseID2 = new JLabel("CourseID");
        lblCourseID2.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblCourseID2.setBounds(40, 10, 100, 30);
        nonAcademicPanel1.add(frame.getContentPane().add(lblCourseID2));

        // CourseID Textfield for Academic Courses
        courseID = new JTextField();
        courseID.setBounds(40, 35, 140, 23);
        academicPanel1.add(frame.getContentPane().add(courseID));
        courseID.setColumns(10);

        // CourseID Textfield for Non-Academic Courses
        courseID2 = new JTextField();
        courseID2.setBounds(40, 35, 140, 23);
        nonAcademicPanel1.add(frame.getContentPane().add(courseID2));
        courseID2.setColumns(10);

        // Course Name label for Academic Courses
        JLabel lblCourseName = new JLabel("Course Name");
        lblCourseName.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblCourseName.setBounds(40, 80, 140, 30);
        academicPanel1.add(frame.getContentPane().add(lblCourseName));

        // Course Name label for Non-Academic Courses
        JLabel lblCourseName2 = new JLabel("Course Name");
        lblCourseName2.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblCourseName2.setBounds(40, 80, 140, 30);
        nonAcademicPanel1.add(frame.getContentPane().add(lblCourseName2));

        // Course Name Textfield for Academic Courses
        courseName = new JTextField();
        courseName.setColumns(10);
        courseName.setBounds(40, 105, 140, 23);
        academicPanel1.add(frame.getContentPane().add(courseName));

        // Course Name Textfield for Non-Academic Courses
        courseName2 = new JTextField();
        courseName2.setColumns(10);
        courseName2.setBounds(40, 105, 140, 23);
        nonAcademicPanel1.add(frame.getContentPane().add(courseName2));

        // Duration label for Academic Courses
        JLabel lblDuration = new JLabel("Duration");
        lblDuration.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblDuration.setBounds(290, 10, 100, 30);
        academicPanel1.add(frame.getContentPane().add(lblDuration));

        // Duration label for Non-Academic Courses
        JLabel lblDuration2 = new JLabel("Duration");
        lblDuration2.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblDuration2.setBounds(290, 10, 100, 30);
        nonAcademicPanel1.add(frame.getContentPane().add(lblDuration2));

        // Duration Textfield for Academic Courses
        duration = new JTextField();
        duration.setColumns(10);
        duration.setBounds(290, 35, 140, 23);
        academicPanel1.add(frame.getContentPane().add(duration));

        // Duration Textfield for Non-Academic Courses
        duration2 = new JTextField();
        duration2.setColumns(10);
        duration2.setBounds(290, 35, 140, 23);
        nonAcademicPanel1.add(frame.getContentPane().add(duration2));

        // Prerequisute label for Non-Academic Courses
        JLabel lblprerequisite = new JLabel("Prerequisite");
        lblprerequisite.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblprerequisite.setBounds(290, 80, 100, 30);
        nonAcademicPanel1.add(frame.getContentPane().add(lblprerequisite));

        // Prerequisite Textfield for Non-Academic Courses
        prerequisite = new JTextField();
        prerequisite.setColumns(10);
        prerequisite.setBounds(290, 105, 140, 23);
        nonAcademicPanel1.add(frame.getContentPane().add(prerequisite));

        // Instructor Name label for Non-Academic Courses
        JLabel lblInstructorName2 = new JLabel("Instructor Name");
        lblInstructorName2.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblInstructorName2.setBounds(40, 80, 120, 30);
        nonAcademicPanel2.add(frame.getContentPane().add(lblInstructorName2));

        // Instructor Name Textfield for Non-Academic Courses
        instructorName = new JTextField();
        instructorName.setColumns(10);
        instructorName.setBounds(40, 105, 140, 23);
        nonAcademicPanel2.add(frame.getContentPane().add(instructorName));

        // Level label for Academic Courses
        JLabel lblLevel = new JLabel("Level");
        lblLevel.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblLevel.setBounds(290, 80, 100, 30);
        academicPanel1.add(frame.getContentPane().add(lblLevel));

        // Level Textfield for Academic Courses
        level = new JTextField();
        level.setColumns(10);
        level.setBounds(290, 105, 140, 23);
        academicPanel1.add(frame.getContentPane().add(level));

        // Course Leader label for Academic Courses
        JLabel lblCourseLeader = new JLabel("Course Leader");
        lblCourseLeader.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblCourseLeader.setBounds(40, 10, 100, 30);
        academicPanel2.add(frame.getContentPane().add(lblCourseLeader));

        // Course Leader label for Non-Academic Courses
        JLabel lblCourseLeader2 = new JLabel("Course Leader");
        lblCourseLeader2.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblCourseLeader2.setBounds(40, 10, 100, 30);
        nonAcademicPanel2.add(frame.getContentPane().add(lblCourseLeader2));

        // Course Leader Textfield for Academic Courses
        courseLeader = new JTextField();
        courseLeader.setColumns(10);
        courseLeader.setBounds(40, 35, 140, 23);
        academicPanel2.add(frame.getContentPane().add(courseLeader));

        // Course Leader Textfield for Non-Academic Courses
        courseLeader2 = new JTextField();
        courseLeader2.setColumns(10);
        courseLeader2.setBounds(40, 35, 140, 23);
        nonAcademicPanel2.add(frame.getContentPane().add(courseLeader2));

        // Lecturer Name label for Academic Courses
        JLabel lblLecturerName = new JLabel("Lecturer Name");
        lblLecturerName.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblLecturerName.setBounds(40, 80, 120, 30);
        academicPanel2.add(frame.getContentPane().add(lblLecturerName));

        // Lecturer Name Textfield for Academic Courses
        lecturerName = new JTextField();
        lecturerName.setColumns(10);
        lecturerName.setBounds(40, 105, 140, 23);
        academicPanel2.add(frame.getContentPane().add(lecturerName));

        // Starting Date label for Academic Courses
        JLabel lblStartingDate = new JLabel("Starting Date");
        lblStartingDate.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblStartingDate.setBounds(290, 10, 120, 30);
        academicPanel2.add(frame.getContentPane().add(lblStartingDate));

        // Starting Date label for Non-Academic Courses
        JLabel lblStartingDate2 = new JLabel("Starting Date");
        lblStartingDate2.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblStartingDate2.setBounds(290, 10, 120, 30);
        nonAcademicPanel2.add(frame.getContentPane().add(lblStartingDate2));

        // Starting Date Textfield for Academic Courses
        startingDate = new JTextField();
        startingDate.setColumns(10);
        startingDate.setBounds(290, 35, 140, 23);
        academicPanel2.add(frame.getContentPane().add(startingDate));

        // Starting Date Textfield for Non-Academic Courses
        startingDate2 = new JTextField();
        startingDate2.setColumns(10);
        startingDate2.setBounds(290, 35, 140, 23);
        nonAcademicPanel2.add(frame.getContentPane().add(startingDate2));

        // Completion Date label for Academic Courses
        JLabel lblCompletionDate = new JLabel("Completion Date");
        lblCompletionDate.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblCompletionDate.setBounds(290, 80, 120, 30);
        academicPanel2.add(frame.getContentPane().add(lblCompletionDate));

        // Completion Date label for Non-Academic Courses
        JLabel lblCompletionDate2 = new JLabel("Completion Date");
        lblCompletionDate2.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblCompletionDate2.setBounds(290, 80, 120, 30);
        nonAcademicPanel2.add(frame.getContentPane().add(lblCompletionDate2));

        // Completion Date Textfield for Academic Courses
        completionDate = new JTextField();
        completionDate.setColumns(10);
        completionDate.setBounds(290, 105, 140, 23);
        academicPanel2.add(frame.getContentPane().add(completionDate));

        // Completion Date Textfield for Non-Academic Courses
        completionDate2 = new JTextField();
        completionDate2.setColumns(10);
        completionDate2.setBounds(290, 105, 140, 23);
        nonAcademicPanel2.add(frame.getContentPane().add(completionDate2));

        // Credit label for Academic Courses
        JLabel lblCredit = new JLabel("Credit");
        lblCredit.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblCredit.setBounds(540, 10, 100, 30);
        academicPanel1.add(frame.getContentPane().add(lblCredit));

        // Credit Textfield for Academic Courses
        credit = new JTextField();
        credit.setColumns(10);
        credit.setBounds(540, 35, 190, 23);
        academicPanel1.add(frame.getContentPane().add(credit));

        // Number of Assessments label for Academic Courses
        JLabel lblNumberOfAssessments = new JLabel("Number of Assessments");
        lblNumberOfAssessments.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNumberOfAssessments.setBounds(540, 80, 190, 30);
        academicPanel1.add(frame.getContentPane().add(lblNumberOfAssessments));

        // Number of Assessments Textfield for Academic Courses
        numberOfAssessments = new JTextField();
        numberOfAssessments.setColumns(10);
        numberOfAssessments.setBounds(540, 105, 190, 23);
        academicPanel1.add(frame.getContentPane().add(numberOfAssessments));

        // Course ID label for Non-Academic courses 4th panel
        JLabel lblcourseIDRemove = new JLabel("Course ID");
        lblcourseIDRemove.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblcourseIDRemove.setBounds(40, 10, 100, 30);
        nonAcademicPanel4.add(frame.getContentPane().add(lblcourseIDRemove));

        // Course ID Textfield for Non-Academic courses 4th panel
        courseIDRemove = new JTextField();
        courseIDRemove.setColumns(10);
        courseIDRemove.setBounds(40, 35, 140, 23);
        nonAcademicPanel4.add(frame.getContentPane().add(courseIDRemove));

        /**
         * ************************************************************** Add button and
         * it's functions for Academic Courses
         ****************************************************************
         */
        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                AcademicCourse data = new AcademicCourse(courseID.getText(), courseName.getText(),
                        ((duration.getText())), level.getText(), credit.getText(), ((numberOfAssessments.getText())),
                        courseLeader.getText(), lecturerName.getText(), startingDate.getText(),
                        completionDate.getText());

                String course = courseID.getText();
                String courseNm = courseName.getText();
                String dur1 = duration.getText();
                String lvl = level.getText();
                String cr = credit.getText();
                String nOfAssessment = numberOfAssessments.getText();

                try {
                    status2 = false;
                    // int courseInt = Integer.parseInt(course2);
                    int durInt = Integer.parseInt(dur1);
                    int crInt = Integer.parseInt(cr);
                    int noOfAssessmentInt = Integer.parseInt(nOfAssessment);

                    if (courseIDArray1.contains(course)) {

                        JOptionPane.showMessageDialog(null, course + " already exists!!");
                        status2 = true;

                    }

                    if (status2 == false) {
                        if (course.length() == 0 || courseNm.length() == 0 || dur1.length() == 0 || lvl.length() == 0
                                || cr.length() == 0 || nOfAssessment.length() == 0) {
                            JOptionPane.showMessageDialog(null, "Field is empty");

                        } else {
                            courseList.add(data);
                            courseIDArray1.add(courseID.getText());
                            JOptionPane.showMessageDialog(null, "Data has been added successfully!!!");
                        }
                    }

                } catch (Exception e) {
                    if (dur1.length() > 0 || cr.length() > 0 || nOfAssessment.length() > 0) {
                        JOptionPane.showMessageDialog(null, "Duration, Credit and No of Assessments has to be Integer");
                    }

                    else {
                        JOptionPane.showMessageDialog(null, "Field is empty");

                    }
                }

                displayCourseDetails();
            }
        });
        btnAdd.setBounds(645, 150, 85, 25);
        academicPanel1.add(frame.getContentPane().add(btnAdd));

        /**
         * ************************************************************** Add button and
         * it's functions for Non-Academic Courses
         ****************************************************************
         */
        JButton btnAdd2 = new JButton("Add");
        btnAdd2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                NonAcademicCourse data2 = new NonAcademicCourse(courseID2.getText(), courseName2.getText(),
                        duration2.getText(), prerequisite.getText(), courseLeader2.getText(), instructorName.getText(),
                        startingDate2.getText(), completionDate2.getText());

                String course2 = courseID2.getText();
                String courseN = courseName2.getText();
                String dur = duration2.getText();
                String preq = prerequisite.getText();
                try {
                    status = false;
                    // int courseInt = Integer.parseInt(course2);
                    int durInt = Integer.parseInt(dur);

                    if (courseIDArray.contains(course2)) {

                        JOptionPane.showMessageDialog(null, course2 + " already exists!!");
                        status = true;

                    }

                    if (status == false) {
                        if (course2.length() == 0 || courseN.length() == 0 || dur.length() == 0 || preq.length() == 0) {
                            JOptionPane.showMessageDialog(null, "Field is empty");

                        } else {
                            courseList2.add(data2);
                            courseIDArray.add(courseID2.getText());
                            JOptionPane.showMessageDialog(null, "Data has been added successfully!!!");

                        }
                    }

                } catch (Exception e) {
                    if (dur.length() > 0) {
                        JOptionPane.showMessageDialog(null, "Duration has to be Integer");
                    } else {
                        JOptionPane.showMessageDialog(null, "Field is empty");

                    }
                }

                displayCourseDetails();
            }
        });
        btnAdd2.setBounds(430, 150, 85, 25);
        nonAcademicPanel1.add(frame.getContentPane().add(btnAdd2));

        /**
         * ************************************************************** Remove button
         * and it's functions for Non-Academic Courses
         ****************************************************************
         */
        JButton btnRemove2 = new JButton("Remove");
        btnRemove2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int choice = JOptionPane.showConfirmDialog(null, "Delete this data ?", "Delete",
                            JOptionPane.YES_NO_OPTION);
                    if (choice == 0) {
                        tblModel2.removeRow(row2);
                        courseList2.remove(row2);
                        courseIDArray.remove(courseIDRemove.getText());
                        displayCourseDetails();
                    }

                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(null, "Course ID doesn't exist!!");
                }

            }
        });
        btnRemove2.setBounds(95, 150, 85, 25);
        nonAcademicPanel4.add(frame.getContentPane().add(btnRemove2));

        /**
         * ************************************************************** Register
         * button and it's functions for Academic Courses
         ****************************************************************
         */
        JButton btnRegister = new JButton("Register");
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                courseList.get(row).courseID = courseID.getText();
                courseList.get(row).courseName = courseName.getText();
                courseList.get(row).duration = (duration.getText());
                courseList.get(row).level = level.getText();
                courseList.get(row).credit = credit.getText();
                courseList.get(row).numberOfAssessments = numberOfAssessments.getText();
                courseList.get(row).courseLeader = courseLeader.getText();
                courseList.get(row).lecturerName = lecturerName.getText();
                courseList.get(row).startingDate = startingDate.getText();
                courseList.get(row).completionDate = completionDate.getText();

                displayCourseDetails();
                JOptionPane.showMessageDialog(null, "Data has been registered successfully!!!");

            }
        });
        btnRegister.setBounds(645, 105, 85, 25);
        academicPanel2.add(frame.getContentPane().add(btnRegister));

        /**
         * ************************************************************** Register
         * button and it's functions for Non-Academic Courses
         ****************************************************************
         */
        JButton btnRegister2 = new JButton("Register");
        btnRegister2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                courseList2.get(row2).courseID2 = courseID2.getText();
                courseList2.get(row2).courseName2 = courseName2.getText();
                courseList2.get(row2).duration2 = duration2.getText();
                courseList2.get(row2).prerequisite = prerequisite.getText();
                courseList2.get(row2).courseLeader2 = courseLeader2.getText();
                courseList2.get(row2).instructorName = instructorName.getText();
                courseList2.get(row2).startingDate2 = startingDate2.getText();
                courseList2.get(row2).completionDate2 = completionDate2.getText();

                displayCourseDetails();
                JOptionPane.showMessageDialog(null, "Data has been registered successfully!!!");

            }
        });
        btnRegister2.setBounds(645, 105, 85, 25);
        nonAcademicPanel2.add(frame.getContentPane().add(btnRegister2));

        /**
         * ************************************************************** Clear button
         * and it's functions for Academic Courses
         ****************************************************************
         */
        JButton btnClear = new JButton("Clear");
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                courseID.setText("");
                courseName.setText("");
                duration.setText("");
                numberOfAssessments.setText("");
                level.setText("");
                courseLeader.setText("");
                credit.setText("");
                lecturerName.setText("");
                startingDate.setText("");
                completionDate.setText("");
            }
        });
        JLabel screenClear = new JLabel("*To clear the screen, press: ------------->");

        screenClear.setBounds(50, 40, 300, 15);
        screenClear.setForeground(Color.RED);
        screenClear.setFont(new Font("Arial", Font.BOLD, 13));
        academicPanel4.add(frame.getContentPane().add(screenClear));

        btnClear.setBounds(294, 35, 85, 25);
        academicPanel4.add(frame.getContentPane().add(btnClear));

        /**
         * ************************************************************** Clear button
         * and it's functions for Non-Academic Courses
         ****************************************************************
         */
        JButton btnClear2 = new JButton("Clear");
        btnClear2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                courseID2.setText("");
                courseName2.setText("");
                duration2.setText("");
                prerequisite.setText("");
                courseLeader2.setText("");
                instructorName.setText("");
                startingDate2.setText("");
                completionDate2.setText("");
                courseIDRemove.setText("");
            }
        });
        JLabel screenClear2 = new JLabel("*To clear the screen, press: ------------->");

        screenClear2.setBounds(50, 40, 300, 15);
        screenClear2.setForeground(Color.RED);
        screenClear2.setFont(new Font("Arial", Font.BOLD, 13));
        nonAcademicPanel5.add(frame.getContentPane().add(screenClear2));

        btnClear2.setBounds(294, 35, 85, 25);
        nonAcademicPanel5.add(frame.getContentPane().add(btnClear2));

        /**
         * ************************************************************** Display button
         * and it's functions for Academic Courses
         ****************************************************************
         */
        JButton btnDisplay = new JButton("Display");
        btnDisplay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JFrame frame2 = new JFrame();
                frame2.setSize(800, 800);
                frame2.add(new JScrollPane(table));
                frame2.setVisible(true);

            }
        });
        JLabel screenDisplay = new JLabel("*To display records, press: ");

        screenDisplay.setBounds(40, 40, 300, 15);
        screenDisplay.setForeground(Color.RED);
        screenDisplay.setFont(new Font("Arial", Font.BOLD, 13));
        academicPanel3.add(frame.getContentPane().add(screenDisplay));
        btnDisplay.setBounds(220, 35, 85, 25);
        academicPanel3.add(frame.getContentPane().add(btnDisplay));

        /**
         * ************************************************************** 
         * Display button and it's functions for Non-Academic Courses
         ****************************************************************
         */
        JButton btnDisplay2 = new JButton("Display");
        btnDisplay2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JFrame frame3 = new JFrame();
                frame3.setSize(800, 800);
                frame3.add(new JScrollPane(table2));
                frame3.setVisible(true);

            }
        });
        JLabel screenDisplay2 = new JLabel("*To display records, press: ");

        screenDisplay2.setBounds(40, 40, 300, 15);
        screenDisplay2.setForeground(Color.RED);
        screenDisplay2.setFont(new Font("Arial", Font.BOLD, 13));
        nonAcademicPanel3.add(frame.getContentPane().add(screenDisplay2));

        btnDisplay2.setBounds(220, 35, 85, 25);
        nonAcademicPanel3.add(frame.getContentPane().add(btnDisplay2));

        /**
         * ************************************************************** Creation of a
         * Scroll Pane 1 and adding it to the table
         ****************************************************************
         */
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(279, 36, 737, 339);
        panel3.add(frame.getContentPane().add(scrollPane));

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                row = table.getSelectedRow();

                courseID.setText(tblModel.getValueAt(row, 0).toString());
                courseName.setText(tblModel.getValueAt(row, 1).toString());
                duration.setText(tblModel.getValueAt(row, 2).toString());
                level.setText(tblModel.getValueAt(row, 3).toString());
                credit.setText(tblModel.getValueAt(row, 4).toString());
                numberOfAssessments.setText(tblModel.getValueAt(row, 5).toString());
                courseLeader.setText(tblModel.getValueAt(row, 6).toString());
                lecturerName.setText(tblModel.getValueAt(row, 7).toString());
                startingDate.setText(tblModel.getValueAt(row, 8).toString());
                completionDate.setText(tblModel.getValueAt(row, 9).toString());

            }
        });
        scrollPane.setViewportView(table);

        /**
         * ************************************************************** Creation of
         * Scroll Pane 2 and adding it to the table
         ****************************************************************
         */
        JScrollPane scrollPane2 = new JScrollPane();
        scrollPane2.setBounds(279, 36, 737, 339);
        panel3.add(frame.getContentPane().add(scrollPane));

        table2 = new JTable();
        table2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                row2 = table2.getSelectedRow();
                courseID2.setText(tblModel2.getValueAt(row2, 0).toString());
                courseIDRemove.setText(tblModel2.getValueAt(row2, 0).toString());
                courseName2.setText(tblModel2.getValueAt(row2, 1).toString());
                duration2.setText(tblModel2.getValueAt(row2, 2).toString());
                prerequisite.setText(tblModel2.getValueAt(row2, 3).toString());
                courseLeader2.setText(tblModel2.getValueAt(row2, 4).toString());
                instructorName.setText(tblModel2.getValueAt(row2, 5).toString());
                startingDate2.setText(tblModel2.getValueAt(row2, 6).toString());
                completionDate2.setText(tblModel2.getValueAt(row2, 7).toString());

            }
        });
        scrollPane2.setViewportView(table2);

        frame.setLayout(null);
        frame.setVisible(true);

    }

}
