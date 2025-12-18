package com.bluecollar.utility;


import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.bluecollar.entity.Sequence;
import com.bluecollar.exception.BlueCollarException;

@Component
public class Utilities {
	
	private static MongoOperations mongoOperation;
	
	@Autowired
	public void setMongoOperation(MongoOperations mongoOperation) {
		Utilities.mongoOperation = mongoOperation;
	}
	
	public static Long getNextSequenceId(String key) throws BlueCollarException {
		Query query = new Query(Criteria.where("_id").is(key));
		Update update = new Update();
		update.inc("seq", 1);
		FindAndModifyOptions options = new FindAndModifyOptions();
		options.returnNew(true);
		Sequence seqId = mongoOperation.findAndModify(query, update, options, Sequence.class);
		if (seqId == null) {
			throw new BlueCollarException("Unable to get sequence id for key : " + key);
		}

		return seqId.getSeq();
	}
	
	public static String generateOTP() {
		StringBuilder otp = new StringBuilder();
		SecureRandom secureRandom = new SecureRandom();
		for (int i = 0; i < 6; i++) {
			otp.append(secureRandom.nextInt(10));
		}
		return otp.toString();
	}
}
