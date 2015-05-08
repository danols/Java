import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Collections;
import java.util.Vector;
 
 
public class AdminFrame extends JFrame {
 
    public static final int widthFrame = 500;
    public static final int heightFrame = 250; 
 
    private Panel panelmSearch, panelmAdd, panelmView, panelmEdit, panelAddStudent;
    private ImageIcon logo = new ImageIcon("mainicon.png");
    private JButton btnAddStudent, btnViewStudents, btnEditStudent, btnSearchStudent,btnaddSubjects,btnReturn,btnaccept;
    private JLabel lbllogo, lblAddStudent, lblViewStudents, lblEditStudent, lblSearchStudent;
    private JLabel lblnameStudent,lblidStudent,lblgroupStudent,lblday,lblmonth,lblyear,lblnumSubjects;
    private JTextField txfSearch, txfnameStudent, txfidStudent, txfgroupStudent, txfday,txfmonth,txfyear, txfnumSubjects;
    private JTextField[] txfnameSubject, txfqualification, txflevel;
    private JTextArea[] txaInfostudents;
 
    private Container mainPanel ;
 
    public AdminFrame() {
 
        setTitle("Sistema De Administración Estudiantes");
        setSize(widthFrame,heightFrame);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
         
        FlowLayout Layout = new FlowLayout();
     
        mainPanel = getContentPane();
        mainPanel.setLayout(Layout);
         
        panelmSearch = new Panel(5,10,1);
        panelmAdd = new Panel(5,10,1);
        panelmView = new Panel(5,10,1);
        //panelmEdit = new Panel(5,10,1);
 
        txfSearch = new JTextField(12);
 
        btnSearchStudent = new JButton("Buscar Alumno");
        btnViewStudents = new JButton("Ver Alumnos");
        btnAddStudent = new JButton("Agregar Alumno");
        btnEditStudent = new JButton("Modificar Alumno");
 
        ButtonHandler btnHandler = new ButtonHandler();
 
        btnSearchStudent.addActionListener(btnHandler);
        btnViewStudents.addActionListener(btnHandler);
        btnAddStudent.addActionListener(btnHandler);
        btnEditStudent.addActionListener(btnHandler);
 
        lbllogo = new JLabel(logo);
        lblSearchStudent = new JLabel(new ImageIcon("search.png"));
        lblViewStudents = new JLabel(new ImageIcon("view.png"));
        lblAddStudent = new JLabel(new ImageIcon("add.png"));
        lblEditStudent = new JLabel(new ImageIcon("edit.png"));
 
        panelmSearch.add(lblSearchStudent);
        panelmSearch.add(txfSearch);
        panelmSearch.add(btnSearchStudent);
 
        panelmAdd.add(lblAddStudent);
        panelmAdd.add(btnAddStudent);
 
        panelmView.add(lblViewStudents);
        panelmView.add(btnViewStudents);
 
        //panelmEdit.add(lblEditStudent);
        //panelmEdit.add(btnEditStudent);
 
        mainPanel.add(lbllogo);
        mainPanel.add(panelmSearch);
        mainPanel.add(panelmAdd);
        mainPanel.add(panelmView);
        //mainPanel.add(panelmEdit);
 
        paintComponents(getGraphics());
 
    }
 
    public class Panel extends JPanel {
        Panel(int v, int h,int align) {
            FlowLayout Layout = new FlowLayout();
            if(align == 1) Layout.setAlignment(FlowLayout.LEFT);
            if(align == 2) Layout.setAlignment(FlowLayout.CENTER);
            if(align == 3) Layout.setAlignment(FlowLayout.RIGHT);
            Layout.setVgap(v);
            Layout.setHgap(h);
            setLayout(Layout);
        }
    }
 
    public static void main(String[] args) {
        AdminFrame adminFrame = new AdminFrame();
    }
 
    private class ButtonHandler implements ActionListener {
 
        int numSubjects = 0;
        int numStudents = 0;
        Vector<Student> students = new Vector<Student>();
 
        public void actionPerformed(ActionEvent e) {
             
            mainPanel.removeAll();
 
            if(e.getSource() == btnSearchStudent) {
                Panel panelLogo = new Panel(5,10,1);
                JLabel lblLogo = new JLabel(new ImageIcon("searchS.png"));
                JLabel lblLogo2 = new JLabel(new ImageIcon("searchF.png"));
                lblLogo2.setToolTipText("Alumno NO Encontrado");
                Student s = new Student(Integer.parseInt(txfSearch.getText()));
                int idx = Collections.binarySearch(students,s);
                 
                if(idx < 0) mainPanel.add(lblLogo2);
                if(idx >= 0) {
                    Panel panelInfo = new Panel(5,10,1);
                    String info = (students.elementAt(idx)).toString();
                    info += ( "\n\n Lista De Materias" + (students.elementAt(idx)).getSubjects() );
                    JTextArea txaInfo = new JTextArea(info);
                    panelInfo.add(txaInfo);
                    mainPanel.add(lblLogo);
                    mainPanel.add(panelInfo);
                }
                mainPanel.add(btnReturn);
            }
            if(e.getSource() == btnAddStudent) {
                panelAddStudent = new Panel(5,10,1);
                Panel panelAddStudent1 = new Panel(5,10,1);
                Panel panelAddStudent2 = new Panel(5,10,1);
                Panel panelAddStudent3 = new Panel(5,10,1);
                Panel panelAddStudent4 = new Panel(5,10,1);
                Panel panelLogo = new Panel(5,10,1);
                Panel panelfooter = new Panel(5,10,1);
 
                JLabel lblLogo = new JLabel(new ImageIcon("addB.png"));
                btnaddSubjects = new JButton("Materias",new ImageIcon("addS.png"));
                btnReturn = new JButton("Menú Principal",new ImageIcon("returnb.png"));
                btnaddSubjects.addActionListener(this);
                btnReturn.addActionListener(this);
 
                txfnameStudent = new JTextField(15);
                txfidStudent = new JTextField(10);
                txfgroupStudent = new JTextField(5);
                txfday = new JTextField(2);
                txfmonth = new JTextField(2);
                txfyear = new JTextField(4);
                txfnumSubjects = new JTextField(2);
             
                lblnameStudent = new JLabel("Nombre ");
                lblidStudent = new JLabel("Boleta ");
                lblgroupStudent = new JLabel("Grupo ");
                lblday = new JLabel("Día ");
                lblmonth = new JLabel("Mes ");
                lblyear = new JLabel("Año ");
                lblnumSubjects = new JLabel("Número de Materias ");
 
                panelLogo.add(lblLogo);
 
                panelAddStudent.add(lblnameStudent);
                panelAddStudent.add(txfnameStudent);
 
                panelAddStudent1.add(lblidStudent);
                panelAddStudent1.add(txfidStudent);
 
                panelAddStudent2.add(lblgroupStudent);
                panelAddStudent2.add(txfgroupStudent);
 
                panelAddStudent3.add(lblday);
                panelAddStudent3.add(txfday);
 
                panelAddStudent3.add(lblmonth);
                panelAddStudent3.add(txfmonth);
 
                panelAddStudent3.add(lblyear);
                panelAddStudent3.add(txfyear);
 
                panelAddStudent4.add(lblnumSubjects);
                panelAddStudent4.add(txfnumSubjects);
 
                panelfooter.add(btnaddSubjects);
                panelfooter.add(btnReturn);
 
                mainPanel.add(panelLogo);
                mainPanel.add(panelAddStudent);
                mainPanel.add(panelAddStudent1);
                mainPanel.add(panelAddStudent2);
                mainPanel.add(panelAddStudent3);
                mainPanel.add(panelAddStudent4);
                mainPanel.add(panelfooter);
 
                 
            }
            if(e.getSource() == btnViewStudents) {
                Panel panelInfo = new Panel(5,5,1);
                JLabel lblLogo = new JLabel(new ImageIcon("viewS.png"));
                String[] info = new String[students.size()];
                txaInfostudents = new JTextArea[students.size()];
                Collections.sort(students);
                for(int i=0;i<students.size();i++) {
                    info[i] = (students.elementAt(i)).toString();
                    info[i] += ( "\n\n Lista De Materias" + (students.elementAt(i)).getSubjects() );
                    txaInfostudents[i] = new JTextArea(info[i]);
                    panelInfo.add(txaInfostudents[i]);
                }
                mainPanel.add(lblLogo);
                mainPanel.add(panelInfo);
                mainPanel.add(btnReturn);
            }
            //if(e.getSource() == btnEditStudent) {}
            if(e.getSource() == btnaddSubjects) {
         
                students.add(new Student (
                    txfnameStudent.getText(),
                    Integer.parseInt(txfidStudent.getText()),
                    txfgroupStudent.getText(),
                    Integer.parseInt(txfnumSubjects.getText()),
                    new Date(Integer.parseInt(txfday.getText()),Integer.parseInt(txfmonth.getText()),Integer.parseInt(txfyear.getText()))
                ));
                numStudents++;
                numSubjects = Integer.parseInt(txfnumSubjects.getText());
 
                btnaccept = new JButton("Guardar Datos",new ImageIcon("save.png"));
                btnaccept.addActionListener(this);
 
                JLabel lbllogoadd = new JLabel(new ImageIcon("addSub.png"));
                JLabel lblnameSubject = new JLabel("Materia");
                JLabel lblqualificationSubject = new JLabel("Calificación");
                JLabel lbllevelSubject = new JLabel("Nivel ");
 
                Panel panelTitle = new Panel(5,15,1);
 
                JLabel[] lblIndex = new JLabel[numSubjects];
                txfnameSubject = new JTextField[numSubjects];
                txfqualification = new JTextField[numSubjects];
                txflevel = new JTextField[numSubjects];
                Panel[] panelInfo = new Panel[numSubjects];
 
                panelTitle.add(lblnameSubject);
                panelTitle.add(lblqualificationSubject);
                panelTitle.add(lbllevelSubject);
 
                mainPanel.add(lbllogoadd);
                mainPanel.add(panelTitle);
 
                for(int i=0;i<numSubjects;i++) {
                    txfnameSubject[i] = new JTextField(12);
                    txfqualification[i] = new JTextField(2);
                    txflevel[i] = new JTextField(2);
                    lblIndex[i] = new JLabel(Integer.toString(i+1));
                    panelInfo[i] = new Panel(5,5,1);
                    panelInfo[i].add(lblIndex[i]);
                    panelInfo[i].add(txfnameSubject[i]);
                    panelInfo[i].add(txfqualification[i]);
                    panelInfo[i].add(txflevel[i]);
                    mainPanel.add(panelInfo[i]);
                }
                 
                mainPanel.add(btnaccept);
                mainPanel.add(btnReturn);
 
            }
            if(e.getSource() == btnaccept) {
                for(int i=0;i<(students.elementAt(numStudents - 1)).getNumSubjects();i++) {
                    (students.elementAt(numStudents - 1)).assignSubject (txfnameSubject[i].getText(),Double.parseDouble(txfqualification[i] .getText()),Integer.parseInt(txflevel[i].getText()));
                }
 
                mainPanel.add(lbllogo);
                mainPanel.add(panelmSearch);
                mainPanel.add(panelmAdd);
                mainPanel.add(panelmView);
                //mainPanel.add(panelmEdit);
            }
            if(e.getSource() == btnReturn) {
                mainPanel.add(lbllogo);
                mainPanel.add(panelmSearch);
                mainPanel.add(panelmAdd);
                mainPanel.add(panelmView);
                //mainPanel.add(panelmEdit);
            }
            paintComponents(getGraphics());
        }
    }
 
}
