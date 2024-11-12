//
//  HomeScreen.swift
//  iosApp
//
//  Created by Jorge Agullo Martin on 11/11/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import Shared
import KMPObservableViewModelSwiftUI
import KMPNativeCoroutinesAsync

struct HomeScreen: View {
    
    @StateViewModel
    var viewModel = HomeViewModel(repository: DiHelper().repository)
    
    var body: some View {
        if !viewModel.characters.isEmpty {
            LazyVStack {
                ForEach(viewModel.characters, id:\.self) { character in
                    Text(character.name)
                }
            }
        } else {
            Text("Error")
        }
    }
}

#Preview {
    HomeScreen()
}
