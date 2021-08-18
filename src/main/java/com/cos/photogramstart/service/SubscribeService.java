package com.cos.photogramstart.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.photogramstart.domain.subscribe.SubscribeRepository;
import com.cos.photogramstart.handler.ex.CustomApiException;
import com.cos.photogramstart.web.dto.subscribe.SubscribeDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SubscribeService {
	
	private final SubscribeRepository subscribeRepository;
	
	@Transactional(readOnly = true)
	public List<SubscribeDto> subscribeList(int principalId, int pageUserId){
		
		return null;
	}
	
	
	@Transactional
	public void follow(int fromUserId, int toUserId) {
		try {
			subscribeRepository.mSubsciribe(fromUserId, toUserId);
		}catch(Exception e){
			throw new CustomApiException("이미 구독한 유저입니다.");
		}
	}
	
	@Transactional
	public void unFollow(int fromUserId, int toUserId) {
		subscribeRepository.mUnSubsciribe(fromUserId, toUserId);
	}

}