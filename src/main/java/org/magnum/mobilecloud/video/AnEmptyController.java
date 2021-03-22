/*
 * 
 * Copyright 2014 Jules White
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package org.magnum.mobilecloud.video;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.magnum.mobilecloud.video.repository.Video;
import org.magnum.mobilecloud.video.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;

@Controller
public class AnEmptyController {
	
	/**
	 * You will need to create one or more Spring controllers to fulfill the
	 * requirements of the assignment. If you use this file, please rename it
	 * to something other than "AnEmptyController"
	 * 
	 * 
		 ________  ________  ________  ________          ___       ___  ___  ________  ___  __       
		|\   ____\|\   __  \|\   __  \|\   ___ \        |\  \     |\  \|\  \|\   ____\|\  \|\  \     
		\ \  \___|\ \  \|\  \ \  \|\  \ \  \_|\ \       \ \  \    \ \  \\\  \ \  \___|\ \  \/  /|_   
		 \ \  \  __\ \  \\\  \ \  \\\  \ \  \ \\ \       \ \  \    \ \  \\\  \ \  \    \ \   ___  \  
		  \ \  \|\  \ \  \\\  \ \  \\\  \ \  \_\\ \       \ \  \____\ \  \\\  \ \  \____\ \  \\ \  \ 
		   \ \_______\ \_______\ \_______\ \_______\       \ \_______\ \_______\ \_______\ \__\\ \__\
		    \|_______|\|_______|\|_______|\|_______|        \|_______|\|_______|\|_______|\|__| \|__|
                                                                                                                                                                                                                                                                        
	 * 
	 */
	
	private VideoRepository videoRepository;
	private static final AtomicLong currentId = new AtomicLong(0L);
	private Map<Long, Video> video = new HashMap<Long, Video>();

	@RequestMapping(value="/go", method=RequestMethod.GET)
	public @ResponseBody String goodLuck(){
		return "Good Luck!";
	}
	
	@GetMapping(value="/video")
	public @ResponseBody Collection<Video> getVideoList() {
		return video.values();
	}
	
	@GetMapping(value="/video/{id}")
	public @ResponseBody Video getVideoById(@PathVariable("id") long id, HttpServletResponse response) {
		Video v = new Video();
		try {
			v = video.get(id);
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
		return v;
	}
	
	@PostMapping(value="/video")
	public @ResponseBody Video addVideo(@RequestBody Video v, HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			v.setId(currentId.incrementAndGet());
			v.setLikes(0);
			video.put(v.getId(), v);
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
		return v;
	}

	@PostMapping(value="/video/{id}/like")
	public void likeVideo(@PathVariable("id") long id, HttpServletResponse response) {
		try {
			Video v = video.get(id);
			if (v.getLikes() == 1) {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			} else if (v.getLikes() == 0) {
				v.setLikes(1);
				response.setStatus(HttpServletResponse.SC_OK);
			} 
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
	}

	@PostMapping(value="/video/{id}/unlike")
	public void unlikeVideo(@PathVariable("id") long id, HttpServletResponse response) {
		try {
			Video v = video.get(id);
			if (v.getLikes() == 1) {
				v.setLikes(0);
				response.setStatus(HttpServletResponse.SC_OK);
			} else {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			}
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
	}
	
	@GetMapping(value="/video/search/findByName")
	public @ResponseBody Collection<Video> findByName(@RequestParam("title") String title) {
		Map<Long,Video> list = new HashMap<>();
		for (Video value: video.values()) {
			if( value.getName().equals(title))
				list.put(value.getId(),value);
		}
		return list.values();
	}
	
	@GetMapping(value="/video/search/findByDurationLessThan")
	public @ResponseBody Collection<Video> findByDurationLessThan(@RequestParam("duration") long duration) {
		Map<Long,Video> list = new HashMap<>();
		for (Video value: video.values()) {
			if (value.getDuration() < duration) {
				list.put(value.getId(),value);
			}
		}
		return list.values();
	}
}
