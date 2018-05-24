//
//  UserService.swift
//  Groupe1iOS
//
//  Created by Yvan Moté on 24/05/2018.
//  Copyright © 2018 Hetic. All rights reserved.
//

import Foundation
import Alamofire
import SwiftyJSON

typealias ResultUsers = (_ users: [Contact]) -> Void
typealias ErrorUsers = (_ error: Error) -> Void

class UserService {
    
    
    static func fetchUsers(result: @escaping ResultUsers, failure: @escaping ErrorUsers) {
        
        let url = UrlBuilder.usersUrl
        
        Alamofire.request(url).responseJSON { (response) in
            
            let statusCode = response.response?.statusCode ?? 400
            
            switch response.result {
            case .success(let resultJson):
                
                // Parsing
                let jsonRootObject = JSON(resultJson)
                
                let results = jsonRootObject["results"].arrayValue
                
                var contacts = [Contact]()
                
                for jsonObject in results {
                    let contact = Contact(jsonObject: jsonObject)
                    
                    contacts.append(contact)
                }
                
                // Retour de la réponse
                
                result(contacts)
                
                break
            case .failure(let error):
                
                failure(error)
                
                break
            }
        }
        
        
    }
    
    
}
