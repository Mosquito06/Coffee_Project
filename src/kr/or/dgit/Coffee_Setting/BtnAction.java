package kr.or.dgit.Coffee_Setting;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import kr.or.dgit.Coffee_Setting.service.DbService;
import kr.or.dgit.Coffee_Setting.service.ExportService;
import kr.or.dgit.Coffee_Setting.service.ImportService;
import kr.or.dgit.Coffee_Setting.service.InitService;

// 동일 버튼에 대한 이벤트를 구현하는 또 다른 방법
// actionPerformed만 가능함
// AbstractAction을 상속받아 구현
public class BtnAction extends AbstractAction {

	public BtnAction(String name) {
		super(name);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DbService service = null;
		// 초기화, 백업, 복원
		switch (e.getActionCommand()) {
		case "초기화":
			service = InitService.getInstance();
			break;
		case "백업":
			service = ExportService.getInstance();
			break;
		case "복원":
			service = ImportService.getInstance();
			break;
		}
		service.service();
		JOptionPane.showMessageDialog(null, e.getActionCommand() + "가(이) 완료되었습니다.");
	}

}
