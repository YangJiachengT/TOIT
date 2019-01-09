package cn.liu.controller.admin.course;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.hutool.http.HttpRequest;
import cn.liu.service.course.ExamServiceImpl;
import cn.liu.util.DateUtil;
import cn.liu.util.bean.Record;
import cn.liu.util.bean.Ret;

@RestController
@RequestMapping("/exam")
public class ExamController {
	
	@Autowired ExamServiceImpl examServiceImpl;
	
	/*---------------------------选择题---------------------------*/
	
	/**
	 * 
	 * @Description: 选择题库列表    
	 * @author liu
	 * @version 2019 年 01 月 09 日  10:39:24 
	 * @return
	 */
	@RequestMapping("couMultiQuestion")
	public List<Record> couMultiQuestionList() {
		return examServiceImpl.getCouMultiQuestionList();
	}
	
	/**
	 * 
	 * @Description: 选择题导入    
	 * @author liu
	 * @version 2019 年 01 月 09 日  10:45:16 
	 * @return
	 */
	@RequestMapping("couMultiQuestion/import")
	public Ret couMultiQuestionImport(MultipartFile file,HttpServletRequest request) {
		return examServiceImpl.importCouMultiQuestion(file, request);
	}
	
	/**
	 * 
	 * @Description: 选择题导入模板下载    
	 * @author yang
	 * @version 2019 年 01 月 09 日  11:13:05 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("couMultiQuestion/export")
	public Ret couMultiQuestionExport(HttpServletRequest request,HttpServletResponse response) {
		try {
			String fileName = MessageFormat.format("题库导入模板_{0}.xls", DateUtil.dateToStr(new Date(), "yyMMddHHmmss"));
			response.setContentType("application/octet-stream;charset=GB18030");
			response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("GB18030"), "ISO-8859-1"));
			String importPath = request.getServletContext().getRealPath("")+"import";
			String excelTemplate = importPath + File.separator + "multi_question_import_templet.xls";
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
			return Ret.ok();
		}catch (Exception e) {
	        e.printStackTrace();
	    }
		return Ret.fail();
	}
}
