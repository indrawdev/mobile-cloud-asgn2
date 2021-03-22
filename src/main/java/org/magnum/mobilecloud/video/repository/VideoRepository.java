package org.magnum.mobilecloud.video.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface VideoRepository extends CrudRepository<Video, Long> {
	
	public Video findById(long id);
	
	public Collection<Video> findByName(String name);
	
	public Collection<Video> findByDurationLessThan(long duration);
}
