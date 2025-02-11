package com.soin.sgrm.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soin.sgrm.dao.AmbientDao;
import com.soin.sgrm.model.Ambient;

@Transactional("transactionManager")
@Service("AmbientService")
public class AmbientServiceImpl implements AmbientService {

	@Autowired
	AmbientDao dao;

	@Override
	public List<Ambient> list(Integer id) {
		return dao.list(id);
	}

	@Override
	public List<Ambient> list(String search, String system) {
		return dao.list(search, system);
	}

	@Override
	public void addReleaseAmbient(Integer release_id, Integer ambient_id) throws SQLException {
		dao.addReleaseAmbient(release_id, ambient_id);
	}

	@Override
	public void deleteReleaseAmbient(Integer release_id, Integer ambient_id) throws SQLException {
		dao.deleteReleaseAmbient(release_id, ambient_id);
	}

	@Override
	public Ambient findById(Integer id, String system) {
		return dao.findById(id, system);
	}

	@Override
	public List<Ambient> list() {
		return dao.list();
	}

	@Override
	public Ambient findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public void save(Ambient ambient) {
		dao.save(ambient);
	}

	@Override
	public void update(Ambient ambient) {
		dao.update(ambient);
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}

}
