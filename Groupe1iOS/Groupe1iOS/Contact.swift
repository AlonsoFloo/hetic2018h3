//
//  Contact.swift
//  Groupe1iOS
//
//  Created by Yvan Moté on 24/05/2018.
//  Copyright © 2018 Hetic. All rights reserved.
//

import Foundation
import SwiftyJSON

class Contact {
    var firstName: String
    var lastName: String
    var phoneNumber: String
    
    var pictureUrl: String!
    
    init(firstName: String, lastName: String, phoneNumber: String) {
        self.firstName = firstName
        self.lastName = lastName
        self.phoneNumber = phoneNumber
    }
    
}

extension Contact {
    convenience init(jsonObject: JSON) {
        let firstName = jsonObject["name"]["first"].stringValue
        let lastName = jsonObject["name"]["last"].stringValue
        let phoneNumber = jsonObject["phone"].stringValue
        self.init(firstName: firstName, lastName: lastName, phoneNumber: phoneNumber)
        
        self.pictureUrl = jsonObject["picture"]["thumbnail"].stringValue
    }
}
