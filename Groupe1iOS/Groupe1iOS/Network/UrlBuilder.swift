//
//  UrlBuilder.swift
//  Groupe1iOS
//
//  Created by Yvan Moté on 24/05/2018.
//  Copyright © 2018 Hetic. All rights reserved.
//

import Foundation

class UrlBuilder {
    
    static let baseUrl: String = {
        return "https://randomuser.me"
    }()
    
    static let usersUrl: String = {
        return "\(UrlBuilder.baseUrl)/api?results=20"
    }()
}
