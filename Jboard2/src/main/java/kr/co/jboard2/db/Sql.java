package kr.co.jboard2.db;

public class Sql {

	// user
	public static final String INSERT_USER = "insert into `board_user` set "
											+ "`uid`=?,"
											+ "`pass`=SHA2(?, 256),"
											+ "`name`=?,"
											+ "`nick`=?,"
											+ "`email`=?,"
											+ "`hp`=?,"
											+ "`zip`=?,"
											+ "`addr1`=?,"
											+ "`addr2`=?,"
											+ "`regip`=?,"
											+ "`rdate`=NOW()";
	
	public static final String SELECT_TERMS = "select * from `board_terms`";
	public static final String SELECT_USER  = "select * from `board_user` where `uid`=? and `pass`=SHA2(?, 256)";
	public static final String SELECT_USER_BY_SESSID = "SELECT * FROM `board_user` WHERE `sessId`=? AND `sessLimitDate` > NOW()";
	
	public static final String SELECT_COUNT_UID = "select count(`uid`) from `board_user` where `uid`=?";
	public static final String SELECT_COUNT_NICK = "select count(`nick`) from `board_user` where `nick`=?";
	public static final String SELECT_USER_FOR_FIND_ID = "select * from `board_user` where `name`=? and `email`=?";
	public static final String SELECT_USER_FOR_FIND_PW = "select * from `board_user` where `uid`=? and `email`=?";
	
	public static final String SELECT_ARTICLES_BY_KEYWORD = "select * from `board_article` as a "
														+ "join `board_user` as b on a.uid = b.uid "
														+ "where `parent`= 0 and (`title` like ? or `nick` like ?) "
														+ "order by `no` desc "
														+ "limit ?, 10";
	
	public static final String SELECT_USER_FOR_INFO = "select * from `board_user` where `pass`= SHA2(? , 256)";
	
	public static final String UPDATE_USER = "update `board_user` set `pass`=SHA2(?, 256), `name` = ?, `nick`=?, `email`=?, `hp`=?, `zip`=?, `addr1`=?, `addr2`=? where = `uid` = ?"; 
	
	public static final String UPDATE_USER_PASSWORD = "update `board_user` set `pass`=SHA2(?, 256) where `uid`=?";
	public static final String UPDATE_USER_FOR_SESSION = "UPDATE `board_user` SET `sessId`=?, `sessLimitDate` = DATE_ADD(NOW(), INTERVAL 3 DAY) WHERE `uid`=?";
	public static final String UPDATE_USER_FOR_SESS_LIMIT_DATE = "UPDATE `board_user` SET `sessLimitDate` = DATE_ADD(NOW(), INTERVAL 3 DAY) WHERE `sessId`=?";
	public static final String UPDATE_USER_FOR_SESSION_OUT = "UPDATE `board_user` SET `sessId`=NULL, `sessLimitDate`=NULL WHERE `uid`=?";
	
	
	// board
	public static final String INSERT_ARTICLE = "insert into `board_article` set "
												+ "`title`=?,"
												+ "`content`=?,"
												+ "`file`=?,"
												+ "`uid`=?,"
												+ "`regip`=?,"
												+ "`rdate`=NOW()";
		
	public static final String INSERT_FILE = "insert into `board_file` set "
											+ "`parent`=?,"
											+ "`newName`=?,"
											+ "`oriName`=?";
	
	public static final String INSERT_COMMENT = "insert into `board_article` set "
												+ "`parent`=?,"
												+ "`content`=?,"
												+ "`uid`=?,"
												+ "`regip`=?,"
												+ "`rdate`=NOW()";
	
	
	public static final String SELECT_MAX_NO = "SELECT MAX(`no`) FROM `board_article`";
	
	public static final String SELECT_COUNT_TOTAL = "SELECT COUNT(`no`) FROM `board_article`  WHERE `parent`=0";
	
	public static final String SELECT_COUNT_TOTAL_FOR_SEARCH = "select count(`no`) from `board_article` as a "
													+ "join `board_user` as b on a.uid = b.uid "
													+ "where `parent`= 0 and (`title` like ? or `nick` like ?)";

	public static final String SELECT_ARTICLES = "SELECT a.*, b.nick FROM `board_article` AS a "
												+ "JOIN `board_user` AS b "
												+ "ON a.uid = b.uid "
												+ "WHERE `parent` = 0 "
												+ "ORDER BY `no` DESC "
												+ "LIMIT ?, 10";
	
	public static final String SELECT_ARTICLE = "SELECT a.*, b.fno, b.parent AS pno, b.newName, b.oriName, b.download "
												+ "FROM `board_article` AS a "
												+ "LEFT JOIN `board_file` AS b "
												+ "ON a.`no` = b.`parent` "
												+ "WHERE `no`=?";
	
	public static final String SELECT_FILE = "select * from `board_file` where `parent`=?";
	
	public static final String SELECT_COMMENTS = "SELECT a.*, b.`nick` FROM `board_article` AS a "
												+ "JOIN `board_user` AS b "
												+ "ON a.uid = b.uid "
												+ "WHERE `parent`=? ORDER BY `no` ASC";
	
	public static final String SELECT_COMMENT_LATEST = "SELECT a.*, b.nick from `board_article` AS a "
														+ "JOIN `board_user` AS b USING (`uid`) "
														+ "WHERE `parent`!=0 ORDER BY `no` DESC LIMIT 1";    
	
	public static final String UPDATE_ARTICLE = "update `board_article` set `title`=?, `content`=?, `rdate`=NOW() where `no`=?";   
	public static final String UPDATE_ARTICLE_HIT = "UPDATE `board_article` SET `hit` = `hit` + 1 WHERE `no`=?";
	public static final String UPDATE_FILE_DOWNLOAD = "update `board_file` set `download` = `download` + 1 where `fno`=?";
	public static final String UPDATE_ARTICLE_COMMENT_PLUS  = "update `board_article` set `comment`=`comment` + 1 where `no`=?";
	public static final String UPDATE_ARTICLE_COMMENT_MINUS = "update `board_article` set `comment`=`comment` - 1 where `no`=?";
	
	public static final String UPDATE_COMMENT = "update `board_article` set "
												+ "`content`=?,"
												+ "`rdate`=NOW() "
												+ "where `no`=?";
	
	
	public static final String DELETE_ARTICLE = "delete from `board_article` where `no`=? or `parent`=?";
	public static final String DELETE_COMMENT  = "delete from `board_article` where `no`=?";
	public static final String DELETE_FILE  = "delete from `board_file` where `parent`=?";
	
}