package com.soin.sgrm.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.soin.sgrm.model.Release;
import com.soin.sgrm.model.ReleaseEdit;
import com.soin.sgrm.model.ReleaseObject;
import com.soin.sgrm.model.ReleaseObjectEdit;
import com.soin.sgrm.model.Risk;
import com.soin.sgrm.model.Status;
import com.soin.sgrm.model.ReleaseSummary;
import com.soin.sgrm.model.ReleaseUser;
import com.soin.sgrm.model.UserInfo;
import com.soin.sgrm.utils.JsonSheet;
import com.soin.sgrm.utils.ReleaseCreate;

public interface ReleaseDao {
	/* Creado para visualizar la paginacion por ajax de 10 items */
	JsonSheet<?> listByUser(String name, int sEcho, int iDisplayStart, int iDisplayLength, String sSearch,
			String[] dateRange, Integer systemId, Integer statusId) throws SQLException, ParseException;

	JsonSheet<?> listByTeams(String name, int sEcho, int iDisplayStart, int iDisplayLength, String sSearch,
			Object[] ids, String[] dateRange, Integer systemId, Integer statusId) throws SQLException, ParseException;

	JsonSheet<?> listByAllSystem(String name, int sEcho, int iDisplayStart, int iDisplayLength, String sSearch,
			String[] filtred, String[] dateRange, Integer systemId, Integer statusId) throws SQLException, ParseException;
	/* #Paginacion por ajax de 10 items# */

	Integer countByType(String name, String type, int query, Object[] ids);

	Integer existNumRelease(String number_release);

	ReleaseSummary findById(Integer id);

	ReleaseEdit findEditById(Integer id) throws SQLException;

	ReleaseUser findReleaseUserById(Integer id) throws SQLException;

	void save(Release release, String tpos) throws Exception;

	void copy(ReleaseEdit release, String tpos) throws Exception;

	List<ReleaseUser> list(String search, String release_id);

	void updateStatusRelease(ReleaseEdit release) throws Exception;

	Release findReleaseById(Integer id);

	void saveRelease(Release release, ReleaseCreate rc) throws Exception;

	void assignRelease(ReleaseEdit release, UserInfo user) throws SQLException;

	void requestRelease(Release release);

	ArrayList<ReleaseObjectEdit> saveReleaseObjects(Integer release_id, ArrayList<ReleaseObjectEdit> objects);

}
