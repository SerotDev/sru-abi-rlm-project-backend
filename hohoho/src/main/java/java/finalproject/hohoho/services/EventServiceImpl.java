package java.finalproject.hohoho.services;

import java.finalproject.hohoho.dao.IEventDAO;
import java.finalproject.hohoho.dto.Event;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements IEventService{
	@Autowired
	IEventDAO iEventDAO;

	@Override
	public List<Event> listar() {
		return iEventDAO.findAll();

	}

	@Override
	public Event guardar(Event event) {
		return iEventDAO.save(event);

	}

	@Override
	public Event porIdentificador(int id) {
		return iEventDAO.findById(id).get();

	}

	@Override
	public Event actualizar(Event event) {
		return iEventDAO.save(event);

	}

	@Override
	public void eliminar(int id) {
		iEventDAO.deleteById(id);				
		
	}
	
}

