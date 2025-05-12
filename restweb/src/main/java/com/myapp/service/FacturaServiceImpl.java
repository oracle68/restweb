package com.myapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.myapp.dao.FacturaDao;
import com.myapp.model.Factura;
import com.myapp.service.FacturaService;

@Service
@Transactional
public class FacturaServiceImpl implements FacturaService { 

	@Autowired
	private FacturaDao facturaDao;

	@Override
	public Factura findById(long Id) { 

		return facturaDao.findById(Id);
	}

	@Override
	
	public List<Factura> findAll() {
		return facturaDao.findAll();
	}

	@Override

	public void addFactura(Factura factura) {
		facturaDao.addFactura(factura);

	}

	@Override
	public void deleteFactura(long Id) {
		facturaDao.deleteFactura(Id);

	}

	@Override
	public void updateFactura(Factura factura) {
		facturaDao.updateFactura(factura);
		
	}

}
