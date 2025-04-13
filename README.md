# FetchTest2025 by cj3dreams (Jamshed S.)
<a href="https://fetch.com/">
    <img alt="©2023 Fetch. This is Fetch icon, a little bit redesigned by me, it's not meaning that you can use that!" src="https://raw.githubusercontent.com/cj3dreams/FetchChicago/master/app/src/main/res/mipmap-xxxhdpi/ic_launcher.png">
</a>

©2025 Fetch. This is the Fetch icon, slightly redesigned by me. It doesn't mean that you're allowed to use it.

## This is a Take Home Test from Fetch Rewards

**Used language:**
Kotlin + Android XML, 

**My stack:**
MVVM + Usecases, Single Activity

**Used dependencies:**
Koin, Coroutines, Retrofit, Logging Interceptor (for tests).

## The objectives of the task were:
1. To get an array from the REST API.
2. Order the items first by "listId" and then by "name".
3. Filter out any items where "name" is null or blank.
4. Display the items as a readable list.

## Extra things I added:

1. Coroutines: Wrote code using Kotlin Coroutines (competently, for my level), especially for REST request.
2. SwipeToUpdate: You can swipe to refresh to get the remote list.

Main thing: I wrote the code almost as best as I could, even though I didn't have to do a lot for this small test task. Some extra touches: icon, card view, progress bar etc

### How it works in short:
**Sorted Array**

*The app fetches an array from https://fetch-hiring.s3.amazonaws.com/hiring.json using Retrofit + GsonConverter. The data is passed through a usecase (where it gets sorted) from the data repository to the viewModel. The sorted data is then provided to the UI (in this case, a RecyclerView). This is done in the viewModel - observed by MutableLiveData, which makes it easy to update the UI. Koin makes dependency injection a breeze! :)*


