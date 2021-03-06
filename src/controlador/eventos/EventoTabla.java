package controlador.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import org.w3c.dom.events.MouseEvent;

import controlador.ParaUI;

public class EventoTabla implements MouseListener {

	private ParaUI paraUI;

	public EventoTabla(ParaUI paraUI) {
		this.paraUI = paraUI;
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		this.paraUI.mostrarDatos();
		this.paraUI.botones.btnBaja(true);
		this.paraUI.botones.btnModificar(true);
		this.paraUI.botones.txt(true);
		this.paraUI.botones.radial(true);
		this.paraUI.botones.chk(true);
		this.paraUI.botones.combo(true);
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {

	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
