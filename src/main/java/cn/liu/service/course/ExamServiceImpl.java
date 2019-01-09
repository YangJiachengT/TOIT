package cn.liu.service.course;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.liu.mapper.CouMultiQuestionMapper;
import cn.liu.po.CouMultiQuestion;
import cn.liu.util.DbUtils;
import cn.liu.util.bean.Record;
import cn.liu.util.bean.Ret;

@Service
public class ExamServiceImpl {

	@Autowired
	CouMultiQuestionMapper couMultiQuestionMapper;

	/*---------------------------选择题---------------------------*/

	public List<Record> getCouMultiQuestionList() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * ");
		sql.append("  FROM cou_multi_question ");
		return DbUtils.find(sql.toString());
	}
	
	/**
	 * 
	 * @Description: 选择题导入    
	 * @author liu
	 * @version 2019 年 01 月 09 日  14:06:44 
	 * @param file
	 * @param request
	 * @return
	 */
	public Ret importCouMultiQuestion(MultipartFile file,HttpServletRequest request) {
		if(file.isEmpty()) {
			return Ret.fail().setMessage("文件为空");
		}
		try {
			List<List<Object>> data = getDataByExcel(3,file.getInputStream(), file.getOriginalFilename());
			
			List<CouMultiQuestion> error = new ArrayList<>();
			for (List<Object> list : data) {
				CouMultiQuestion entity = new CouMultiQuestion();
				//课程编号
				entity.setCourseCode(2018121402);
				//题目
				entity.setQuestion(String.valueOf(list.get(0)));
				//选项A
				entity.setOptionA(String.valueOf(list.get(1)));
				//选项B
				entity.setOptionB(String.valueOf(list.get(2)));
				//选项C
				entity.setOptionC(String.valueOf(list.get(3)));
				//选项D
				entity.setOptionD(String.valueOf(list.get(4)));
				//选项E
				entity.setOptionE(StringUtils.isEmpty(String.valueOf(list.get(5))) ? null : String.valueOf(list.get(5)));
				//选项F
				entity.setOptionF(StringUtils.isEmpty(String.valueOf(list.get(6))) ? null : String.valueOf(list.get(6)));
				//答案
				String answer = String.valueOf(list.get(7));
 				entity.setAnswer(answer);
 				String regEx = "[G-Zg-z0-9]+";
 				Pattern pattern = Pattern.compile(regEx);
 				Matcher matcher = pattern.matcher(answer);
 				boolean rs = matcher.matches();
				if(rs == true) {
					error.add(entity);
					continue;
				}
				//阶段
				entity.setStage((int) ((Cell) list.get(8)).getNumericCellValue());
				//难度
				entity.setLevel((int) ((Cell) list.get(9)).getNumericCellValue());
				
				couMultiQuestionMapper.insert(entity);
			}
			
			return Ret.ok().setMessage(error);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Ret.fail();
	}
	
	/*---------------------------Excel导入通用方法 Start---------------------------*/
	
	/**
	 * 
	 * @Description: 获取上传的excel表里的数据    
	 * @author liu
	 * @version 2019 年 01 月 09 日  16:10:57 
	 * @param startRow 模板中数据开始行 （从0开始）
	 * @param in 
	 * @param fileName
	 * @return
	 */
	@SuppressWarnings({ "unused"})
	public List<List<Object>> getDataByExcel(Integer startRow,InputStream in, String fileName) {
		List<List<Object>> list = new ArrayList<List<Object>>();;
		try {
			Workbook wb = getWorkbook(in, fileName);
			Sheet sheet = wb.getSheetAt(0);
			Row row = null;
			Cell cell = null;
			for (int i = startRow; i <= sheet.getLastRowNum(); i++) {
				row = sheet.getRow(i);
				if (row == null || row.getFirstCellNum() == i) {
					continue;
				}

				List<Object> li = new ArrayList<Object>();
				for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
					cell = row.getCell(j);
					li.add(cell);
				}
				list.add(li);
			}
			if (null == wb) {
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 
	 * @Description: 判断上传文件格式    
	 * @author liu
	 * @version 2019 年 01 月 09 日  16:12:13 
	 * @param inStr
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public Workbook getWorkbook(InputStream inStr, String fileName) throws Exception {
		Workbook wb = null;
		String fileType = fileName.substring(fileName.lastIndexOf("."));
		if (".xls".equals(fileType)) {
			wb = new HSSFWorkbook(inStr);
		} else if (".xlsx".equals(fileType)) {
			wb = new XSSFWorkbook(inStr);
		} else {
			throw new Exception("解析的文件格式有误！");
		}
		return wb;
	}
	
	/*---------------------------Excel导入通用方法 End---------------------------*/
}
