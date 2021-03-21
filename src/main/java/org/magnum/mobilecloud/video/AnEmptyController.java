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

import java.util.Collection;

import org.magnum.mobilecloud.video.client.VideoSvcApi;
import org.magnum.mobilecloud.video.repository.Video;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping(value="/go", method=RequestMethod.GET)
	public @ResponseBody String goodLuck(){
		return "Good Luck!";
	}
	
	@GetMapping(value="/video")
	public @ResponseBody Collection<Video> getVideoList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@GetMapping(value="/video/{id}")
	public @ResponseBody Video getVideoById(@PathVariable("id") long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@PostMapping(value="/video")
	public @ResponseBody Video addVideo(Video v) {
		// TODO Auto-generated method stub
		return null;
	}

	@PostMapping(value="/video/{id}/like")
	public @ResponseBody Void likeVideo(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@PostMapping(value="/video/{id}/unlike")
	public Void unlikeVideo(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@GetMapping(value="/video/search/findByName?title={title}")
	public @ResponseBody Collection<Video> findByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@GetMapping(value="/video/search/findByDurationLessThan?duration={duration}")
	public @ResponseBody Collection<Video> findByDurationLessThan(long duration) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
