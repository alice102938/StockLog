import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;

public class Login {
    public static void main(String[] args) {
        JFrame f = new JFrame("로그인창");
        JPanel panel = new JPanel(new GridBagLayout());

        JLabel l1 = new JLabel("ID");
        JTextField text = new JTextField(15);

        JLabel l2 = new JLabel("passwd");
        JPasswordField value = new JPasswordField(15);

        ((AbstractDocument) text.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("[a-zA-Z]*")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });

        ((AbstractDocument) value.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("[a-zA-Z]*")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });

        JButton b = new JButton("로그인");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(l1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(text, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(l2, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(value, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(b, gbc);

        f.add(panel);

        f.setSize(420, 350);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = text.getText();
                String passwd = new String(value.getPassword());

                if (id.isEmpty() || passwd.isEmpty()) {
                    JOptionPane.showMessageDialog(f, "로그인에 실패했습니다. ID와 비밀번호를 모두 입력하세요.");
                } else {
                    String data = id + "님 로그인에 성공하셨습니다.";
                    JOptionPane.showMessageDialog(f, data);
                }
            }
        });
    }
}
