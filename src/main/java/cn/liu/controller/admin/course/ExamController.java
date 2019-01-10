package cn.liu.controller.admin.course;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	@RequestMapping("couMultiQuestionList")
	public List<Record> couMultiQuestionList() {
		return examServiceImpl.getCouMultiQuestionList();
	}
	
	/**
	 * 
	 * @Description: 选择题题库导入    
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
	 * @author liu
	 * @version 2019 年 01 月 09 日  11:13:05 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("couMultiQuestion/export")
	public void couMultiQuestionExport(HttpServletRequest request,HttpServletResponse response) {
		try {
			String fileName = MessageFormat.format("题库导入模板_选择题_{0}.xls", DateUtil.dateToStr(new Date(), "yyMMddHHmmss"));
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
			//HSSFSheet sheet = wb.getSheetAt(0);
			
			// 明细BLOCK end
			OutputStream fOut = response.getOutputStream();
			wb.write(fOut);
			fOut.flush();
			response.setStatus(HttpServletResponse.SC_OK);
			fOut.close();
			wb.close();
		}catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	/*---------------------------判断题---------------------------*/
	
	/**
	 * 
	 * @Description: 判断题列表    
	 * @author liu
	 * @version 2019 年 01 月 10 日  09:22:50 
	 * @return
	 */
	@RequestMapping("couJudgeQuestionList")
	public List<Record> couJudgeQuestionList() {
		return examServiceImpl.getCouJudgeQuestionList();
	}
	
	/**
	 * 
	 * @Description: 判断题题库导入    
	 * @author liu
	 * @version 2019 年 01 月 10 日  09:23:07 
	 * @param file
	 * @param request
	 * @return
	 */
	@RequestMapping("couJudgeQuestion/import")
	public Ret couJudgeQuestionImport(MultipartFile file,HttpServletRequest request) {
		return examServiceImpl.importCouJudgeQuestion(file, request);
	}
	
	/**
	 * 
	 * @Description: 判断题导入模板下载    
	 * @author liu
	 * @version 2019 年 01 月 10 日  09:23:39 
	 * @param request
	 * @param response
	 */
	@RequestMapping("couJudgeQuestion/export")
	public void couJudgeQuestionExport(HttpServletRequest request,HttpServletResponse response) {
		try {
			String fileName = MessageFormat.format("题库导入模板_判断题_{0}.xls", DateUtil.dateToStr(new Date(), "yyMMddHHmmss"));
			response.setContentType("application/octet-stream;charset=GB18030");
			response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("GB18030"), "ISO-8859-1"));
			String importPath = request.getServletContext().getRealPath("")+"import";
			String excelTemplate = importPath + File.separator + "judge_question_import_templet.xls";
			// excel模板路径
			File fi = new File(excelTemplate);
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(fi));
			// 读取excel模板
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			// 读取excel模板
			//HSSFSheet sheet = wb.getSheetAt(0);
			
			// 明细BLOCK end
			OutputStream fOut = response.getOutputStream();
			wb.write(fOut);
			fOut.flush();
			response.setStatus(HttpServletResponse.SC_OK);
			fOut.close();
			wb.close();
		}catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	/*---------------------------判断题---------------------------*/
	
	
}
