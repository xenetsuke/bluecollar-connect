package com.bluecollar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluecollar.dto.ProfileDTO;
import com.bluecollar.entity.Profile;
import com.bluecollar.exception.BlueCollarException;
import com.bluecollar.repository.ProfileRepository;
import com.bluecollar.utility.Utilities;

@Service("profileService")
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	private ProfileRepository profileRepository;

	@Override
	public Long createProfile(String email) throws BlueCollarException {
		// TODO Auto-generated method stub
		Profile profile=new Profile();
		profile.setId(Utilities.getNextSequenceId("profiles"));
		profile.setEmail(email);
//		profile.setName(userDTO.getName());
		profile.setSkills(new ArrayList<>());
//		profile.setExperiences(new ArrayList<>());
		profile.setLanguages(new ArrayList<>());
		profileRepository.save(profile);
		return profile.getId();
	}


		@Override
		public ProfileDTO getProfile(Long id) throws BlueCollarException {
			return profileRepository.findById(id).orElseThrow(()->new BlueCollarException("PROFILE_NOT_FOUND")).toDTO();
		}

		@Override
		public ProfileDTO updateProfile(ProfileDTO profileDTO) throws BlueCollarException {
			profileRepository.findById(profileDTO.getId()).orElseThrow(()->new BlueCollarException("PROFILE_NOT_FOUND"));
			profileRepository.save(profileDTO.toEntity());
			return profileDTO;
		}

		@Override
		public List<ProfileDTO> getAllProfiles() throws BlueCollarException {
			return profileRepository.findAll().stream().map((x)->x.toDTO()).toList();
		}
	

}
