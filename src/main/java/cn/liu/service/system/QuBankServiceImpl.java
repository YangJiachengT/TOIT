package cn.liu.service.system;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.stereotype.Service;

import cn.liu.util.DateUtil;
import cn.liu.util.bean.Ret;

@Service
public class QuBankServiceImpl {
	public Ret dlTemplate(HttpServletResponse response,HttpServletRequest request) {
		Ret ret = new Ret();
		try {
			String fileName = MessageFormat.format("题库导入模板_{0}.xls", DateUtil.dateToStr(new Date(), "yyMMddHHmmss"));
			response.setContentType("application/octet-stream;charset=GB18030");
			response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("GB18030"), "ISO-8859-1"));
			String importPath = request.getServletContext().getRealPath("")+"import";
			String excelTemplate = importPath + File.separator + "qu_bank_import.xls";
			// excel模板路径
			File fi = new File(excelTemplate);
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(fi));
			// 读取excel模板
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			// 读取excel模板
			HSSFSheet sheet = wb.getSheetAt(0);
			
			// 明细BLOCK end
			OutputStream fOut = response.getOutputStream();
			wb.write(fOut);
			fOut.flush();
			response.setStatus(HttpServletResponse.SC_OK);
			fOut.close();
			wb.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ret;
	}
}
