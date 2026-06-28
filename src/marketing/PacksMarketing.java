package marketing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class PacksMarketing {

    private JFrame frmMarketing;
    private JTextField txtAntiguitat, txtDtePromocional, txtBase, txtIVA, txtTotal, txtError;
    private JComboBox<String> cmbPack, cmbNegoci, cmbXXSS, cmbSEM;
    private JButton btnValidar, btnCalcular, btnEsborrar;
    private JPanel grupDadesClient, grupCampanya, grupPreus, grupErrors;

    private String missatge;
    private int antiguitat;
    private double dtePromocional;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                PacksMarketing window = new PacksMarketing();
                window.frmMarketing.setVisible(true);
            } catch (Exception e) { e.printStackTrace(); }
        });
    }

    public PacksMarketing() { initialize(); }

    private void initialize() {
        frmMarketing = new JFrame();
        frmMarketing.setTitle("PacksMarketing");
        frmMarketing.setBounds(100, 100, 390, 598);
        frmMarketing.setLocationRelativeTo(null); // centra la finestra a la pantalla
        frmMarketing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmMarketing.setResizable(false);
        frmMarketing.getContentPane().setLayout(null);

        // Constants de layout (uniformitat/alineació)
        final int LBL_X = 10;
        final int FIELD_X = 155;      // mateixa X per tots els inputs de blocs 1 i 2
        final int FIELD_W = 150;      // mateixa amplada per tots els inputs de blocs 1 i 2
        final int ROW_H = 22;

        // --- BLOC 1: DADES CLIENT ---
        grupDadesClient = new JPanel();
        grupDadesClient.setBorder(new TitledBorder(null, "Dades Clients", TitledBorder.LEADING, TitledBorder.TOP));
        grupDadesClient.setBounds(10, 11, 354, 164);
        frmMarketing.getContentPane().add(grupDadesClient);
        grupDadesClient.setLayout(null);

        txtAntiguitat = new JTextField();
        txtAntiguitat.setToolTipText("Anys d'antiguitat de l'empresa (0-150)");
        txtAntiguitat.setBounds(FIELD_X, 25, FIELD_W, 20); // uniforme
        grupDadesClient.add(txtAntiguitat);

        cmbPack = new JComboBox<>(new String[] {"Bàsic", "Estàndard", "Full", "Prèmium"});
        cmbPack.setSelectedIndex(-1);
        cmbPack.setBounds(FIELD_X, 55, FIELD_W, ROW_H); // uniforme
        grupDadesClient.add(cmbPack);

        cmbNegoci = new JComboBox<>(new String[] {"Autònom", "PIME", "Gran empresa"});
        cmbNegoci.setSelectedIndex(-1);
        cmbNegoci.setBounds(FIELD_X, 85, FIELD_W, ROW_H); // uniforme
        grupDadesClient.add(cmbNegoci);

        btnValidar = new JButton("VALIDAR");
        btnValidar.setBounds(117, 118, 120, 23);
        grupDadesClient.add(btnValidar);

        JLabel lblAntiguitatEmpresa = new JLabel("Antiguitat Empresa");
        lblAntiguitatEmpresa.setBounds(LBL_X, 25, 142, 20);
        grupDadesClient.add(lblAntiguitatEmpresa);

        JLabel lblPackServeis = new JLabel("Pack de serveis");
        lblPackServeis.setBounds(LBL_X, 58, 118, 20);
        grupDadesClient.add(lblPackServeis);

        JLabel lblTipusNegoci = new JLabel("Tipus de negoci");
        lblTipusNegoci.setBounds(LBL_X, 89, 118, 20);
        grupDadesClient.add(lblTipusNegoci);

        JLabel lblAnys = new JLabel("anys");
        lblAnys.setBounds(311, 25, 35, 20); // al final del camp
        grupDadesClient.add(lblAnys);

        // --- BLOC 2: CAMPANYA ---
        grupCampanya = new JPanel();
        grupCampanya.setBorder(new TitledBorder(null, "Campanya", TitledBorder.LEADING, TitledBorder.TOP));
        grupCampanya.setBounds(10, 179, 354, 181);
        grupCampanya.setEnabled(false);
        frmMarketing.getContentPane().add(grupCampanya);
        grupCampanya.setLayout(null);

        txtDtePromocional = new JTextField();
        txtDtePromocional.setEnabled(false);
        txtDtePromocional.setToolTipText("Descompte promocional en euros");
        txtDtePromocional.setBounds(FIELD_X, 25, FIELD_W, 20); // uniforme
        grupCampanya.add(txtDtePromocional);

        cmbXXSS = new JComboBox<>(new String[] {"SÍ", "NO"});
        cmbXXSS.setEnabled(false);
        cmbXXSS.setSelectedIndex(-1);
        cmbXXSS.setBounds(FIELD_X, 55, FIELD_W, ROW_H); // uniforme
        grupCampanya.add(cmbXXSS);

        cmbSEM = new JComboBox<>(new String[] {"SÍ", "NO"});
        cmbSEM.setEnabled(false);
        cmbSEM.setSelectedIndex(-1);
        cmbSEM.setBounds(FIELD_X, 85, FIELD_W, ROW_H); // uniforme
        grupCampanya.add(cmbSEM);

        btnCalcular = new JButton("CALCULAR");
        btnCalcular.setEnabled(false);
        btnCalcular.setBounds(117, 147, 120, 23);
        grupCampanya.add(btnCalcular);

        btnEsborrar = new JButton("ESBORRAR TOT");
        btnEsborrar.setEnabled(false);
        btnEsborrar.setBounds(107, 118, 140, 23);
        grupCampanya.add(btnEsborrar);

        JLabel lblDtePromocional = new JLabel("Dte. Promocional");
        lblDtePromocional.setBounds(LBL_X, 25, 138, 20);
        grupCampanya.add(lblDtePromocional);

        JLabel lblGestioXXSS = new JLabel("Gestió de XXSS");
        lblGestioXXSS.setBounds(LBL_X, 56, 118, 20);
        grupCampanya.add(lblGestioXXSS);

        JLabel lblSEM = new JLabel("Publicitat SEM");
        lblSEM.setBounds(LBL_X, 85, 100, 20);
        grupCampanya.add(lblSEM);

        JLabel lblEuros = new JLabel("€");
        lblEuros.setBounds(311, 25, 20, 20); // al final del camp
        grupCampanya.add(lblEuros);

        // --- BLOC 3: PREUS ---
        grupPreus = new JPanel();
        grupPreus.setBorder(new TitledBorder(null, "PREUS", TitledBorder.LEADING, TitledBorder.TOP));
        grupPreus.setBounds(10, 366, 354, 117);
        frmMarketing.getContentPane().add(grupPreus);
        grupPreus.setLayout(null);

        txtBase = new JTextField(); txtBase.setEditable(false); txtBase.setBounds(26, 45, 120, 20); grupPreus.add(txtBase);
        txtIVA = new JTextField(); txtIVA.setEditable(false); txtIVA.setBounds(206, 45, 120, 20); grupPreus.add(txtIVA);
        txtTotal = new JTextField(); txtTotal.setEditable(false); txtTotal.setBounds(117, 84, 120, 20); grupPreus.add(txtTotal);

        JLabel lblBase = new JLabel("Base");
        lblBase.setBounds(26, 25, 37, 20);
        grupPreus.add(lblBase);

        JLabel lblIVA = new JLabel("IVA");
        lblIVA.setBounds(206, 25, 49, 20);
        grupPreus.add(lblIVA);

        JLabel lblEuros1 = new JLabel("€");
        lblEuros1.setBounds(152, 45, 20, 20);
        grupPreus.add(lblEuros1);

        JLabel lblEuros3 = new JLabel("€");
        lblEuros3.setBounds(332, 45, 13, 20);
        grupPreus.add(lblEuros3);

        JLabel lblTotal = new JLabel("TOTAL");
        lblTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblTotal.setBounds(58, 84, 49, 20);
        grupPreus.add(lblTotal);

        JLabel lblEuros2 = new JLabel("€");
        lblEuros2.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblEuros2.setBounds(242, 84, 13, 20);
        grupPreus.add(lblEuros2);

        // --- BLOC 4: ERRORS ---
        grupErrors = new JPanel();
        grupErrors.setBorder(new TitledBorder(null, "Errors i Alertes", TitledBorder.LEADING, TitledBorder.TOP));
        grupErrors.setBounds(10, 493, 354, 55);
        frmMarketing.getContentPane().add(grupErrors);
        grupErrors.setLayout(null);

        txtError = new JTextField();
        txtError.setEditable(false);
        txtError.setBounds(10, 20, 334, 20);
        grupErrors.add(txtError);

        // --- LÒGICA D'ESDEVENIMENTS ---
        btnValidar.addActionListener(e -> {
            if (validarClient()) {
                habilitarBlocClient(false);
                habilitarBlocCampanya(true);
                txtError.setText("");
            } else {
                txtError.setText(missatge);
            }
        });

        btnCalcular.addActionListener(e -> {
            if (validarCampanya()) {
                calcularPressupost();
                txtError.setText("");
            } else {
                txtError.setText(missatge);
            }
        });

        btnEsborrar.addActionListener(e -> {
            habilitarBlocClient(true);
            habilitarBlocCampanya(false);
            netejarCamps();
        });
    }

    // --- MÈTODES DE VALIDACIÓ ---
    private boolean validarClient() {
        try {
            antiguitat = Integer.parseInt(txtAntiguitat.getText());
            if (antiguitat < 0 || antiguitat > 150) throw new Exception();
        } catch (Exception e) {
            enfocar(txtAntiguitat);
            missatge = "L'antiguitat ha de ser un enter entre 0 i 150";
            return false;
        }
        if (cmbPack.getSelectedIndex() == -1) {
            missatge = "Seleccioneu el pack.";
            return false;
        }
        if (cmbNegoci.getSelectedIndex() == -1) {
            missatge = "Seleccioneu el tipus de negoci";
            return false;
        }
        return true;
    }

    private boolean validarCampanya() {
    	try {
            dtePromocional = Double.parseDouble(txtDtePromocional.getText());
            double base = getPreuBasePack();
            if (dtePromocional < 0 || dtePromocional >= base) throw new Exception();
        } catch (Exception e) {
            enfocar(txtDtePromocional);
            missatge = "Dte ha de ser >= 0 i menor al preu base";
            return false;
        }
        if (cmbXXSS.getSelectedIndex() == -1) {
            missatge = "Indiqueu si voleu XXSS.";
            return false;
        }
        if (cmbSEM.getSelectedIndex() == -1) {
            missatge = "Indiqueu si voleu SEM.";
            return false;
        }
        return true;
    }

    // --- CÀLCULS ---
    private void calcularPressupost() {
        double base = getPreuBasePack();
        double factorAntiguitat = (antiguitat >= 10) ? 0.9 : 1.0;

        double factorNegoci;
        int idxNegoci = cmbNegoci.getSelectedIndex();
        if (idxNegoci == 0) factorNegoci = 0.8;      // Autònom
        else if (idxNegoci == 2) factorNegoci = 1.2;  // Gran empresa
        else factorNegoci = 1.0;                       // PIME

        double preuServeis = (base * factorAntiguitat * factorNegoci);
        if (cmbXXSS.getSelectedIndex() == 0) preuServeis += 150;
        if (cmbSEM.getSelectedIndex() == 0) preuServeis += 250;

        double preuAbansImpostos = preuServeis - dtePromocional;
        double iva = preuAbansImpostos * 0.21;
        double total = preuAbansImpostos + iva;

        txtBase.setText(String.format("%.2f", preuAbansImpostos));
        txtIVA.setText(String.format("%.2f", iva));
        txtTotal.setText(String.format("%.2f", total));
    }

    private double getPreuBasePack() {
        switch (cmbPack.getSelectedIndex()) {
            case 0: return 200;
            case 1: return 450;
            case 2: return 800;
            case 3: return 1200;
            default: return 0;
        }
    }

    // --- UTILITATS D'INTERFÍCIE ---
    private void habilitarBlocClient(boolean b) {
        txtAntiguitat.setEditable(b);
        cmbPack.setEnabled(b);
        cmbNegoci.setEnabled(b);
        btnValidar.setEnabled(b);
    }

    private void habilitarBlocCampanya(boolean b) {
        txtDtePromocional.setEnabled(b);
        txtDtePromocional.setEditable(b);
        cmbXXSS.setEnabled(b);
        cmbSEM.setEnabled(b);
        btnCalcular.setEnabled(b);
        btnEsborrar.setEnabled(b);
    }

    private void netejarCamps() {
        txtAntiguitat.setText("");
        txtDtePromocional.setText("");
        cmbPack.setSelectedIndex(-1);
        cmbNegoci.setSelectedIndex(-1);
        cmbXXSS.setSelectedIndex(-1);
        cmbSEM.setSelectedIndex(-1);
        txtBase.setText("");
        txtIVA.setText("");
        txtTotal.setText("");
    }

    private void enfocar(JTextField t) {
        t.requestFocus(); t.selectAll();
    }
}