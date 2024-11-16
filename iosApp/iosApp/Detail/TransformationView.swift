//
//  TransformationView.swift
//  iosApp
//
//  Created by Jorge Agullo Martin on 16/11/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import Shared
import Kingfisher

struct TransformationView: View {
    let transformation: TransformationModel
    
    var body: some View {
        VStack {
            KFImage(URL(string: transformation.image))
                .placeholder { ProgressView() }
                .resizable()
                .scaledToFit()
            Text(transformation.name)
        }.padding(.horizontal, 24)
            .padding(.vertical, 12)
            .cornerRadius(20)
            .shadow(radius: 16)
            .overlay(RoundedRectangle(cornerRadius: 20).stroke(.gray))
    }
}

#Preview {
    TransformationView(transformation: TransformationModel(
        name: "Pepe",
        image: "https://dragonball-api.com/characters/goku_normal.webp",
        ki: "987799")
    )
}
