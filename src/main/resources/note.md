js replaceAll 方法

//利用正则表达式进行全文替换
function replaceAll(str,before,after){
    return str.replace(new RegExp(before,'g'),after);
}

动画js库：Velocity.js
css框架：UIKit https://getuikit.com/

Mysql：
函数 INSTR(列名,?) 
作用：返回字符串在某一个字段的内容中的位置, 没有找到字符串返回0，否则返回位置（从1开始）
INSTR(列名,?) > 0 --->关键字搜索

设置跨域
getResponse().setHeader("Access-Control-Allow-Origin", "*"); // 允许哪些url可以跨域请求到本域
getResponse().setHeader("Access-Control-Allow-Methods", "POST"); // 允许的请求方法，一般是GET,POST,PUT,DELETE,OPTIONS
getResponse().setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type"); // 允许哪些请求头可以跨域

ajax库 axios
前端操作数据库 https://www.prisma.io/

maven
<!-- 使用阿里 maven 库 -->
<repositories>
	<repository>
		<id>ali-maven</id>
		<url>http://maven.aliyun.com/nexus/content/groups/public</url>
		<releases>
			<enabled>true</enabled>
		</releases>
		<snapshots>
			<enabled>true</enabled>
			<updatePolicy>always</updatePolicy>
			<checksumPolicy>fail</checksumPolicy>
		</snapshots>
	</repository>
</repositories>

SpringBoot 配置文件 application.properties :

spring.datasource.url=jdbc:mysql://cdb-d7nyc1ab.gz.tencentcdb.com:10015/blog?characterEncoding=UTF-8
spring.datasource.username=root
spring.datasource.password=yjc201505020529
spring.datasource.driver-class-name=com.mysql.jdbc.Driver

mybatis.mapper-locations=classpath:cn/kojojo/mapper/*.xml
#指定扫描包让mybatis自动扫描到自定义实体类
mybatis.type-aliases-package=cn.kojojo.po

mybatis 执行传入的任意sql语句:
mapper接口： 
public List<LinkedHashMap<String, Object>> find(String sqlContent);
mapper.xml
<select id="find" parameterType="String" resultType="java.util.LinkedHashMap">
	<![CDATA[
	${value}
	]]>
</select>

mysql left join 逗号分隔字段查询

goods表
+----------+-------------+
|    id    |  school_ids |
+----------+-------------+
| 	  1    |    1,2,3    |
| 	  2    |      2      |
|     3    |      2      |
+----------+-------------+
school表
+----------+------------------+
|    id    |  locality_name   |
+----------+------------------+
| 	  1    |    西安科技大学   |
| 	  2    |    西安欧亚学院   |
|     3    |    西安邮电大学   |
+----------+------------------+

SQL：

select g.id,g.school_ids,GROUP_CONCAT(s.locality_name  ORDER BY s.id ASC) 
from goods g 
	left join school s on FIND_IN_SET(s.id , g.school_ids)
GROUP BY g.id
ORDER BY g.id ASC

结果：
+----------+---------------+------------------------------------+
|    id    |  school_ids   |   GROUP_CONCAT(s.locality_name)    |
+----------+---------------+------------------------------------+
| 	  1    |    1,2,3      |西安科技大学,西安欧亚学院,西安邮电大学 | 
| 	  2    |      2        |西安欧亚学院                         |
|     3    |      2        |西安欧亚学院                         |
+----------+---------------+------------------------------------+

Mysql使用count()函数计算两个不同条件的值
select count(case when id>4 then id end),count(case when id=1 then id end ) from test;

bootstrap-markdown 调用
<textarea name="content" data-provide="markdown" data-iconlibrary="fa" rows="10" id="editor"></textarea>
$('#editor').data('markdown').parseContent();
----------------------------------------------------------------------------------
导出代码
public void export() throws Exception {
		try{
			Map<String, Object> cond = this.getSessionAttr(AppConstant.LIST_COND_COOKIE);
			if(cond == null) {
				renderError(500);
				return;
			}
			HttpServletResponse resp = getResponse();

			String fileName = MessageFormat.format("客户导出_{0}.xls",DateUtil.dateToStr(new Date(), "yyMMddHHmmss"));

			resp.setContentType("application/octet-stream;charset=GB18030");
			resp.setHeader("Content-Disposition", "attachment;filename="
					+ new String(fileName.getBytes("GB18030"), "ISO-8859-1"));

			HSSFWorkbook wb = new HSSFWorkbook();
			//-------------------------------------------------------------------------
			//修改点一：表格的sheet名称
			wb.createSheet("客户信息导出");  
			//-------------------------------------------------------------------------
			HSSFSheet sheet = wb.getSheetAt(0);
			//设置字体  
			HSSFFont numberFont10 = PoiExcelExportUtils.createFont(wb,10,"Times New Roman");
			HSSFFont textFont10 = PoiExcelExportUtils.createFont(wb,10,"宋体");
			//标题样式
			HSSFCellStyle title_Cell = PoiExcelExportUtils.createCellStyle(wb,
					PoiExcelExportUtils.createFont(wb,16,"黑体"),HorizontalAlignment.CENTER);
			//打印detail 的表头
			HSSFCellStyle header_Cell = PoiExcelExportUtils.createCellStyle(wb,
					PoiExcelExportUtils.createFont(wb,10,"微软雅黑"),HorizontalAlignment.CENTER);

			HSSFCellStyle detail_textLeftCell = PoiExcelExportUtils.createCellStyle(wb, textFont10, HorizontalAlignment.LEFT);
			detail_textLeftCell.setWrapText(true);
			HSSFCellStyle detail_textCenterCell = PoiExcelExportUtils.createCellStyle(wb, textFont10, HorizontalAlignment.CENTER);
			detail_textCenterCell.setWrapText(true);
			//数值样式
			HSSFCellStyle detail_numberCell = PoiExcelExportUtils.createCellStyle(wb, numberFont10, HorizontalAlignment.RIGHT);
			HSSFCellStyle detail_numberCenterCell = PoiExcelExportUtils.createCellStyle(wb, numberFont10, HorizontalAlignment.CENTER);
			//金额样式
			HSSFCellStyle detail_amountCell = PoiExcelExportUtils.createCellStyle(wb, numberFont10, HorizontalAlignment.RIGHT);
			detail_amountCell.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
			//-------------------------------------------------------------------------
			//修改点二：表格的header
			List<Tuple2<String,Integer>> headerList = Lists.newArrayList();
			//列宽基数184
			headerList.add(tuple("序号",5*256 + 184));
			headerList.add(tuple("客户编号", 10*256 + 184));
			headerList.add(tuple("客户名称", 30*256 + 184));
			headerList.add(tuple("员工总数", 10*256 + 184));
			headerList.add(tuple("协议份数", 10*256 + 184));
			headerList.add(tuple("法定代表人", 14*256 + 184));
			headerList.add(tuple("统一社会信用代码", 30*256 + 184));
			headerList.add(tuple("单位性质", 14*256 + 184));
			headerList.add(tuple("单位规模", 14*256 + 184));
			headerList.add(tuple("官网", 30*256 + 184));
			headerList.add(tuple("行业分类", 14*256 + 184));
			headerList.add(tuple("省份", 14*256 + 184));
			headerList.add(tuple("城市", 14*256 + 184));
			headerList.add(tuple("地址", 30*256 + 184));
			headerList.add(tuple("缴费方式", 10*256 + 184));
			headerList.add(tuple("简介", 30*256 + 184));
			headerList.add(tuple("付款日", 10*256 + 184));
			headerList.add(tuple("结算日", 10*256 + 184));
			headerList.add(tuple("客户来源", 14*256 + 184));
			headerList.add(tuple("有效性", 10*256 + 184));
			headerList.add(tuple("市场开发", 14*256 + 184));
			headerList.add(tuple("客服专员", 14*256 + 184));
			headerList.add(tuple("备注", 30*256 + 184));
			//-------------------------------------------------------------------------
			int row = 0;
			//打印标题
			if(true) {
				//-------------------------------------------------------------------------
				//修改点三：表格的标题
				PoiExcelExportUtils.setCellValue(sheet, row, 0, "客户信息导出").setCellStyle(title_Cell);
				//-------------------------------------------------------------------------
				sheet.getRow(row).setHeightInPoints(40);
				CellRangeAddress cra =new CellRangeAddress(row, row, 0, headerList.size()-1); 
				sheet.addMergedRegion(cra);
				PoiExcelExportUtils.setBorderStyle(sheet, cra);
				row = row + 1;
			}
			//打印表头
			if(true) {
				//打印表头
				int cellIdx = 0;
				for(Tuple2<String,Integer> tuple : headerList) {
					String columnLable = tuple.first;
					PoiExcelExportUtils.setCellValue(sheet, row, cellIdx,columnLable).setCellStyle(header_Cell);
					sheet.setColumnWidth(cellIdx,tuple.second);
					cellIdx++;
				}
				sheet.getRow(row).setHeightInPoints(28);
				row = row + 1;
			}
			Page<Record> page = CmpSelectApi.api.page(1, 50000000, cond);
			List<Record> records = page.getList();
			int i =1;
			//打印数据
			for(Record record: records) {
				int cellIdx = 0;
				//序号
				PoiExcelExportUtils.setCellValue(sheet, row, cellIdx++, i++).setCellStyle(detail_numberCenterCell);
				//客户编号
				PoiExcelExportUtils.setCellValue(sheet, row, cellIdx++, record.getStr("cmp_no")).setCellStyle(detail_numberCenterCell);
				//客户名称
				PoiExcelExportUtils.setCellValue(sheet, row, cellIdx++, record.getStr("cmp_name")).setCellStyle(detail_textLeftCell);
				//员工总数
				PoiExcelExportUtils.setCellValue(sheet, row, cellIdx++, record.getInt("emp_total")).setCellStyle(detail_numberCenterCell);
				//协议份数
				PoiExcelExportUtils.setCellValue(sheet, row, cellIdx++, record.getInt("contract_total")).setCellStyle(detail_numberCenterCell);
				//法定代表人
				PoiExcelExportUtils.setCellValue(sheet, row, cellIdx++, record.getStr("cmp_legal_repr")).setCellStyle(detail_textCenterCell);
				//统一社会信用代码
				PoiExcelExportUtils.setCellValue(sheet, row, cellIdx++, record.getStr("cmp_registe_no")).setCellStyle(detail_textCenterCell);
				//单位性质
				PoiExcelExportUtils.setCellValue(sheet, row, cellIdx++, record.getStr("cmp_nature")).setCellStyle(detail_textCenterCell);
				//单位规模
				PoiExcelExportUtils.setCellValue(sheet, row, cellIdx++, record.getStr("cmp_scale")).setCellStyle(detail_textCenterCell);
				//官网
				PoiExcelExportUtils.setCellValue(sheet, row, cellIdx++, record.getStr("cmp_website")).setCellStyle(detail_textLeftCell);
				//行业分类
				PoiExcelExportUtils.setCellValue(sheet, row, cellIdx++, record.getStr("industry_name")).setCellStyle(detail_textCenterCell);
				//省
				PoiExcelExportUtils.setCellValue(sheet, row, cellIdx++, record.getStr("province_name")).setCellStyle(detail_textCenterCell);
				//市
				PoiExcelExportUtils.setCellValue(sheet, row, cellIdx++, record.getStr("city_name")).setCellStyle(detail_textCenterCell);
				//企业地址
				PoiExcelExportUtils.setCellValue(sheet, row, cellIdx++, record.getStr("cmp_address")).setCellStyle(detail_textLeftCell);
				//缴费方式
				DictEnum dictEnum = DictApi.api.findByIdAndCorpId(getLoginUserCorpId(), record.getInt("pay_mode"));
				String dictEnumStr = (dictEnum == null) ? "":dictEnum.getEnumValue();
				PoiExcelExportUtils.setCellValue(sheet, row, cellIdx++, dictEnumStr).setCellStyle(detail_textCenterCell);
				//简介
				PoiExcelExportUtils.setCellValue(sheet, row, cellIdx++, record.getStr("cmp_profile")).setCellStyle(detail_textLeftCell);
				//付款日
				PoiExcelExportUtils.setCellValue(sheet, row, cellIdx++, record.getStr("pay_day")).setCellStyle(detail_textCenterCell);
				//结算日
				PoiExcelExportUtils.setCellValue(sheet, row, cellIdx++, record.getStr("settle_day")).setCellStyle(detail_textCenterCell);
				//企业来源
				String source_form = record.getStr("cmp_source_from");
				source_form = CmpSourceFormEnum.getDisp(source_form);
				PoiExcelExportUtils.setCellValue(sheet, row, cellIdx++, source_form).setCellStyle(detail_textCenterCell);
				//有效性
				String valid_flg = record.getStr("valid_flg");
				if(valid_flg != null) {
					valid_flg = record.getStr("valid_flg").equals("Y")?"有效":"无效";
				}
				PoiExcelExportUtils.setCellValue(sheet, row, cellIdx++, valid_flg).setCellStyle(detail_textCenterCell);
				//市场开发
				PoiExcelExportUtils.setCellValue(sheet, row, cellIdx++, record.getStr("marketDeveloperStr")).setCellStyle(detail_textCenterCell);
				//客服专员
				PoiExcelExportUtils.setCellValue(sheet, row, cellIdx++, record.getStr("commissioner")).setCellStyle(detail_textCenterCell);
				//备注
				PoiExcelExportUtils.setCellValue(sheet, row, cellIdx++, record.getStr("cmp_desc")).setCellStyle(detail_textLeftCell);
				
				sheet.getRow(row).setHeightInPoints(20);
				row++;
			}
			
			//明细BLOCK end
			OutputStream fOut = resp.getOutputStream();  
			wb.write(fOut);
			fOut.flush();
			resp.setStatus(HttpServletResponse.SC_OK);
			fOut.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		renderNull();
	}