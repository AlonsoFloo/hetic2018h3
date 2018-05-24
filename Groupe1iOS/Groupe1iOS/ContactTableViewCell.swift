//
//  ContactTableViewCell.swift
//  Groupe1iOS
//
//  Created by Yvan Moté on 24/05/2018.
//  Copyright © 2018 Hetic. All rights reserved.
//

import UIKit

class ContactTableViewCell: UITableViewCell {
    
    static let identifier = "contactCellIdentifier"

    @IBOutlet weak var firstNameLabel: UILabel!
    @IBOutlet weak var lastNameLabel: UILabel!
    @IBOutlet weak var phoneNumberLabel: UILabel!
    
    var contact: Contact! {
        // Méthode appelée après que contact ait été modifié
        didSet {
            firstNameLabel.text = contact.firstName
            lastNameLabel.text = contact.lastName
            phoneNumberLabel.text = contact.phoneNumber
        }
    }
}
